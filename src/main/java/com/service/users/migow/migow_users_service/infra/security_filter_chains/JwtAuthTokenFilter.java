// package com.service.users.migow.migow_users_service.infra.security_filter_chains;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.service.users.migow.migow_users_service.infra.providers.JwtTokenProvider;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import java.io.IOException;

// public class JwtAuthTokenFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtTokenProvider tokenProvider;

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         try {
//             String jwt = parseJwt(request);
//             if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
//                 String username = tokenProvider.getUserNameFromJwtToken(jwt);

//                 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                 JwtAuthenticationToken authentication = new JwtAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//                 SecurityContextHolder.getContext().setAuthentication(authentication);
//             }
//         } catch (Exception e) {
//             // log the exception here
//         }

//         filterChain.doFilter(request, response);
//     }

//     private String parseJwt(HttpServletRequest request) {
//         String headerAuth = request.getHeader("Authorization");

//         if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
//             return headerAuth.substring(7, headerAuth.length());
//         }

//         return null;
//     }
// }

