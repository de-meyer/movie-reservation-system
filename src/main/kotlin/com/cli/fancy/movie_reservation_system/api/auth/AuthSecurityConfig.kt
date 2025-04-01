package com.cli.fancy.movie_reservation_system.api.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class AuthSecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorizeRequests ->
            authorizeRequests
                .anyRequest().permitAll()
        }
            .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)} // Disable session creation
            .csrf{csrf -> csrf.disable()} // Disable CSRF
            .formLogin{it.disable()} // Disable form login
            .httpBasic{} // Enable basic authentication
        return http.build()
    }
}