package com.cli.fancy.movie_reservation_system.application.api

import com.cli.fancy.movie_reservation_system.AbstractIntegrationTest
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Transactional
import reactor.test.StepVerifier
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
            .jsonPath("$.length()").isEqualTo(5)


    }

    @Test
    fun `should get movie by id`() {

        val createdMovie = testDataHelper.createMovie(number = "1")
        val movieId = createdMovie.id

        webTestClient.get()
            .uri("/movie/$movieId")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.id").isEqualTo("$movieId")
    }

    @Test
    fun `should delete movie by id`() {
        val createdMovie = testDataHelper.createMovie(number = "1")
        val movieId = createdMovie.id

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