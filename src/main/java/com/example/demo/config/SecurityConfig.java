package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for Swagger and POST requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/auth/**",       // Authentication endpoints
                    "/v3/api-docs/**",    // Swagger API docs
                    "/swagger-ui/**",     // Swagger UI
                    "/swagger-ui.html"    // Swagger UI HTML page
                ).permitAll()             // Allow these endpoints without authentication
                .anyRequest().authenticated() // All other endpoints require authentication
            );

        return http.build();
    }
}
