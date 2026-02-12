package com.cli.fancy.movie_reservation_system.application.api.test

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Simple test controller to verify SpringDoc OpenAPI scanning works.
 * If this appears in /v3/api-docs, then SpringDoc is working correctly.
 * This endpoint is public and does not require authentication (configured in AuthSecurityConfig).
 */
@RestController
@RequestMapping("/test")
@Tag(name = "Test", description = "Test API for OpenAPI verification - public access")
class TestController {

    @GetMapping
    @Operation(summary = "Test endpoint", description = "Returns a simple test message")
    fun test(): Mono<String> {
        return Mono.just("SpringDoc OpenAPI is working!")
    }

    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Simple health check endpoint")
    fun health(): Mono<Map<String, String>> {
        return Mono.just(
            mapOf(
                "status" to "UP",
                "message" to "API is running"
            )
        )
    }
}

