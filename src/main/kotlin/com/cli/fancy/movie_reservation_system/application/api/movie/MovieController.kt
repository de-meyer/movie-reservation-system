package com.cli.fancy.movie_reservation_system.application.api.movie

import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreationRequest
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreationResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.mapper.toBrowseInformationDto
import com.cli.fancy.movie_reservation_system.application.api.movie.mapper.toMovieCreateShowSelection
import com.cli.fancy.movie_reservation_system.application.api.movie.mapper.toMovieCreationResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.mapper.toShowCreationInformation
import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/movie")
@Tag(name = "Movie", description = "Movie management API")
class MovieController(val movieService: MovieService) {

    @GetMapping("/browse")
    @Operation(summary = "Get all movies", description = "Retrieve all available movies for browsing")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved all movies")
        ]
    )
    fun getAllMovies(): Flux<MovieBrowseResponse> {
        return movieService.getAllMovies().map { it.toBrowseInformationDto() }
    }

    @GetMapping("/createShowInformation")
    @Operation(
        summary = "Get movie information for show creation",
        description = "Retrieve movie information needed for creating a show"
    )
    fun getAllMovieInformationsForShowCreation(): Flux<MovieCreateShowResponse> =
        movieService.getAllMovies().map { it.toShowCreationInformation() }

    @PostMapping("/createShow")
    @Operation(summary = "Create a movie show", description = "Create a new movie show with the provided information")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Movie show created successfully"),
            ApiResponse(responseCode = "400", description = "Invalid request body")
        ]
    )
    fun createMovie(
        @RequestBody movieCreationRequest: MovieCreationRequest
    ): Mono<ResponseEntity<MovieCreationResponse>> =
        movieService.createMovieFromRequest(movieCreationRequest)
            .map { ResponseEntity.created(URI.create("/movie/${it.id}")).body(it.toMovieCreationResponse()) }

    @GetMapping("/{id}")
    @Operation(summary = "Get movie by ID", description = "Retrieve a specific movie by its ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved movie"),
            ApiResponse(responseCode = "404", description = "Movie not found")
        ]
    )
    fun getMovieById(
        @Parameter(description = "ID of the movie to retrieve", required = true)
        @PathVariable id: UUID
    ): Mono<MovieCreateShowResponse> =
        movieService.getMovieById(id)
            .map { it.toMovieCreateShowSelection() }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete movie", description = "Delete a movie by its ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "Movie deleted successfully"),
            ApiResponse(responseCode = "404", description = "Movie not found")
        ]
    )
    fun deleteMovie(
        @Parameter(description = "ID of the movie to delete", required = true)
        @PathVariable id: UUID
    ): Mono<ResponseEntity<Void>> {
        return movieService.deleteById(id)
            .then(Mono.just(ResponseEntity.noContent().build()))
    }
}
