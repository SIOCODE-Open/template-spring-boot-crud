package com.example.backend.config;

import com.example.backend.filter.CORSFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class BackendSecurityConfig {

    @Value("${ backend.cors.enabled:true}")
    private boolean corsEnabled;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        if (corsEnabled) {
            http.addFilterAfter(
                new CORSFilter(),
                BasicAuthenticationFilter.class
            );
        }
        http
            // Disable Cross-Site Request Forgery (CSRF) protection
            .csrf(csrf -> csrf.disable())
            // Authorize all HTTP requests without authentication
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}
