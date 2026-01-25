package com.cli.fancy.movie_reservation_system.application.reservation.api

import com.cli.fancy.movie_reservation_system.AbstractIntegrationTest
import org.springframework.http.MediaType
import kotlin.test.Test

class MovieControllerTest : AbstractIntegrationTest() {
    
    @Test
    fun `should create movie`() {
        webTestClient.post()
            .uri("/movie/createShow")
            .bodyValue(
                mapOf(
                    "title" to "Inception",
                    "description" to "foo bar",
                    "durationMinutes" to 90,
                    "director" to "Max Foo Bar",
                    "genre" to "Comedy",
                    "releaseYear" to 2025,
                    "imageProfile" to "profile.jpg",
                    "imageLandscape" to "Landscape.jpg"
                )
            )
            .exchange()
            .expectStatus().isCreated
            .expectHeader().exists("Location")
            .expectHeader().valueMatches("Location", ".*/movie/.*") // Verify format
            .expectBody()
            .jsonPath("$.id").exists()
            .jsonPath("$.title").isEqualTo("Inception")
    }

    @Test
    fun `should get all movies`() {
        webTestClient.get()
            .uri("/movie/browse")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk

    }
}