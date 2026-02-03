package com.cli.fancy.movie_reservation_system.application.api

import com.cli.fancy.movie_reservation_system.AbstractIntegrationTest
import org.springframework.http.MediaType
import java.util.UUID
import kotlin.test.Test

class MovieControllerTest : AbstractIntegrationTest() {

    @Test
    fun `should create movie`() {
        webTestClient.post()
            .uri("/movie/createShow")
            .bodyValue(
                mapOf(
                    "title" to "Movie 1",
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
            .jsonPath("$.title").isEqualTo("Movie 1")
        
    }

    @Test
    fun `should get all movies`() {
        testDataHelper.createMovies(5)
        webTestClient.get()
            .uri("/movie/browse")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.length()").isEqualTo(27)


    }

    @Test
    fun `should get movie by id`() {
        testDataHelper.createMovieWithId(UUID.fromString("a7f3c4e2-8b1d-4f5a-9c6e-2d8b7a3f1e4c"))
        webTestClient.get()
        .uri("/movie/a7f3c4e2-8b1d-4f5a-9c6e-2d8b7a3f1e4c")
            .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk
        .expectBody()
            .jsonPath() // FIXME Check for uuid
    }

    Here's how to rewrite the test to actually delete a movie and verify it's deleted:
    kotlin

    @Test
    fun `should delete movie by id`() {
        // Arrange - Create a movie
        val movieId = UUID.fromString("a7f3c4e2-8b1d-4f5a-9c6e-2d8b7a3f1e4c")
        testDataHelper.createMovieWithId(movieId)

        webTestClient.get()
            .uri("/movie/$movieId")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk

        webTestClient.delete()
            .uri("/movie/$movieId")
            .exchange()
            .expectStatus().isNoContent  // or .isOk depending on your API

        webTestClient.get()
            .uri("/movie/$movieId")
            .exchange()
            .expectStatus().isNotFound
    }
}