package com.example.backend.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Creates built-in default entities for the Backend application.
 */
@RequiredArgsConstructor
@Slf4j
public class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        // Add the Access-Control-Allow-Origin header to the response
        response.setHeader("Access-Control-Allow-Origin", "*");

        // Add the Access-Control-Allow-Methods header to the response
        response.setHeader(
            "Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS"
        );

        // Add the Access-Control-Allow-Headers header to the response
        response.setHeader(
            "Access-Control-Allow-Headers",
            "Content-Type, Authorization, Encoding, Accept-Encoding, Accept"
        );

        // Filter the request
        filterChain.doFilter(request, response);
    }
}
