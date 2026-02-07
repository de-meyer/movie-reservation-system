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
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/movie")
class MovieController(val movieService: MovieService) {

    @GetMapping("/browse")
    fun getAllMovies(): Flux<MovieBrowseResponse> {
        return movieService.getAllMovies().map { it.toBrowseInformationDto() }
    }

    @GetMapping("/createShowInformation")
    fun getAllMovieInformationsForShowCreation(): Flux<MovieCreateShowResponse> =
        movieService.getAllMovies().map { it.toShowCreationInformation() }

    @PostMapping("/createShow")
    fun createMovie(@RequestBody movieCreationRequest: MovieCreationRequest): Mono<ResponseEntity<MovieCreationResponse>> =
        movieService.createMovieFromRequest(movieCreationRequest)
            .map { ResponseEntity.created(URI.create("/movie/${it.id}")).body(it.toMovieCreationResponse()) }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: UUID): Mono<MovieCreateShowResponse> =
        movieService.getMovieById(id)
            .map { it.toMovieCreateShowSelection() }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: UUID): Mono<ResponseEntity<Void>> {
        return movieService.deleteById(id)
            .then(Mono.just(ResponseEntity.noContent().build()))
    }
}