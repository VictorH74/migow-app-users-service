package com.service.users.migow.migow_users_service.infra.helpers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.service.users.migow.migow_users_service.application.dtos.auth.CustomUserDetails;
import com.service.users.migow.migow_users_service.application.services.JwtService;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.exceptions.user.UserNotFounException;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, java.io.IOException {
        String requestUri = request.getRequestURI();
        log.info("Request URI: " + requestUri);

        String authHeader = request.getHeader("Authorization");
        String token = null;
        UUID userId = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            log.info("Bearer token found in Authorization header");
            token = authHeader.substring(7);
            userId = jwtService.extractUserId(token);
            log.info("Extracted userId: " + userId);
        }

        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info("Username not null and no existing authentication found");

            User user = userRepository.getUserById(userId).orElseThrow(() -> new UserNotFounException("user with id from the given token not found"));
            UserDetails userDetails = new CustomUserDetails(user);

            log.info("Loaded user: " + user);
            if (jwtService.validateToken(token, user.getId())) {
                log.info("Token validated");
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                log.info("Token validation failed");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
                return;
            }

        }

        filterChain.doFilter(request, response);
    }
}
