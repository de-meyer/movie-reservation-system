package com.cli.fancy.movie_reservation_system.application.api.openapi

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

/**
 * Provides a custom endpoint that proxies to the standard SpringDoc OpenAPI endpoint.
 * This is a simple alias for frontend convenience.
 */
@RestController
@Hidden
class OpenApiController {

    @GetMapping("/api/openapi.json", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getOpenApiJson(): Mono<String> {
        // Proxy request to the standard SpringDoc endpoint
        return WebClient.create()
            .get()
            .uri("http://localhost:8080/v3/api-docs")
            .retrieve()
            .bodyToMono<String>()
            .onErrorReturn("{\"error\": \"Could not load OpenAPI specification\"}")
    }
}


