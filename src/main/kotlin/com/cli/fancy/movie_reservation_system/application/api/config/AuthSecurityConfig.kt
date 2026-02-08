package com.cli.fancy.movie_reservation_system.application.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class AuthSecurityConfig(
) {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorizeRequests ->
            authorizeRequests
                .requestMatchers("/user/me").authenticated()
                .anyRequest().permitAll()
        }
            .oauth2Login { oauth ->
                oauth
                    .defaultSuccessUrl("http://localhost:3000", true) // redirect to frontend
            }
            .csrf { csrf -> csrf.disable() } // Disable CSRF
            .httpBasic { it.disable() } // Disable basic authentication
            .cors {} // Enable CORS
        return http.build()
    }
}