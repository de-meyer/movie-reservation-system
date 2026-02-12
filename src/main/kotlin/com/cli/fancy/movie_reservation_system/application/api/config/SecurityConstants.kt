package com.cli.fancy.movie_reservation_system.application.api.config

// Central definition of all publicly accessible paths (no authentication required)
// Used by AuthSecurityConfig and OpenApiConfig
object SecurityConstants {

    val PUBLIC_PATHS = arrayOf(
        "/oauth2/**",
        "/login/**",
        "/logout",
        "/program/**",
        "/test/**",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/webjars/**",
        "/api/openapi.json"
    )
}
