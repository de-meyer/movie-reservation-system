package com.cli.fancy.movie_reservation_system.application.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreationRequest
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreationResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toBrowseInformationDto
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toMovieCreateShowSelection
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toMovieCreationResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toShowCreationInformation
import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/movie")
class MovieController(val movieService: MovieService) {

    // Add your movie-related endpoints here
    // For example:
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
    //FIXME: when not found errorhandling with controller advice

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: UUID): Mono<ResponseEntity<Void>> {
        return movieService.deleteById(id)
            .then(Mono.just(ResponseEntity.noContent().build()))
    }
}