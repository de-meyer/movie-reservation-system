package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.user.PrincipalUser
import com.cli.fancy.movie_reservation_system.api.user.UserService
import com.cli.fancy.movie_reservation_system.utils.JwtService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
@EnableWebSecurity
class AuthSecurityConfig(
    private val jwtService: JwtService,
    private val userService: UserService,
) {

    @Bean
    fun jwtAuthFilter(): JwtAuthFilter {
        return JwtAuthFilter(jwtService, userService)
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authorizeRequests ->
            authorizeRequests
                .requestMatchers("/api/me").authenticated()
                .anyRequest().permitAll()
        }
            .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement{it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)} // Disable session creation
            .csrf{csrf -> csrf.disable()} // Disable CSRF
            .formLogin{it.disable()} // Disable form login
            .httpBasic{} // Enable basic authentication
            .cors{} // Enable CORS
        return http.build()
    }
}
class JwtAuthFilter(
    private val jwtService: JwtService,
    private val userService: UserService,

    ) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val cookie = request.cookies?.find { it.name == "jwt" }?.value
        if (cookie != null ) {
            if (jwtService.validateToken(cookie)) {
                val principleUser: PrincipalUser = jwtService.getPrincipalUserFromToken(cookie) // User ID = email in this context
                val user = userService.getUserByEmail(principleUser.email)
                    ?: throw IllegalArgumentException("User not found")
                val enrichedPrincipalUser = PrincipalUser(
                    name = user.name,
                    email = user.email,
                    role = user.role,
                    id = user.id
                )
                val auth = UsernamePasswordAuthenticationToken(enrichedPrincipalUser, null, emptyList())
                SecurityContextHolder.getContext().authentication = auth
            }
        }

        filterChain.doFilter(request, response)
    }
}