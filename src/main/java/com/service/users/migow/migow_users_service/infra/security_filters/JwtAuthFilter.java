package com.service.users.migow.migow_users_service.infra.security_filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.service.users.migow.migow_users_service.application.services.JwtService;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.UserDetailsServiceImpl;

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
    UserDetailsServiceImpl userDetailsServiceImpl;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, java.io.IOException {
        String requestUri = request.getRequestURI();
        log.info("Request URI: " + requestUri);

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            log.info("Bearer token found in Authorization header");
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
            log.info("Extracted username: " + username);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info("Username not null and no existing authentication found");
            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
            log.info("Loaded user details: " + userDetails);
            if (jwtService.validateToken(token, userDetails)) {
                log.info("Token validated");
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                log.info("Token validation failed");
            }

        }

        filterChain.doFilter(request, response);
    }
}
