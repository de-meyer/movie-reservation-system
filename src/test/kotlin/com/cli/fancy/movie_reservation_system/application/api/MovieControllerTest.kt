package com.cli.fancy.movie_reservation_system.application.api

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
    fun `should return 404 when movie not found`() {
        val nonExistentId = UUID.randomUUID()

        webTestClient.get()
            .uri("/movie/$nonExistentId")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isNotFound
            .expectBody()
            .jsonPath("$.message").exists()
            .jsonPath("$.status").isEqualTo(404)
    }

    @Test
    fun `should get movie information's for the show creation page`() {
        testDataHelper.createMovies(5)
        webTestClient.get()
            .uri("/movie/createShowInformation").accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.length()").isEqualTo(5)
    }

    @Test
    fun `should get movie information's for the show creation page with all fields`() {
        testDataHelper.createMovies(1)
        webTestClient.get()
            .uri("/movie/createShowInformation").accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.length()").isEqualTo(1)
            .jsonPath("$[0].id").isNotEmpty
            .jsonPath("$[0].durationMinutes").isNotEmpty
            .jsonPath("$[0].title").isNotEmpty
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