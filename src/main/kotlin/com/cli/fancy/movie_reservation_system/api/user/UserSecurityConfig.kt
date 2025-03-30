package com.cli.fancy.movie_reservation_system.api.user

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class UserSecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorizeRequests ->
            authorizeRequests.requestMatchers("/api/users/registration").permitAll()
                .anyRequest().authenticated()
        }
            .csrf{csrf -> csrf.disable()} // Disable CSRF
            .formLogin{it.disable()} // Disable form login
            .httpBasic{} // Enable basic authentication
        return http.build()
    }
}