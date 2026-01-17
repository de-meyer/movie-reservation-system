package com.cli.fancy.movie_reservation_system.application.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toBrowseInformationDto
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toMovieCreateShowSelection
import com.cli.fancy.movie_reservation_system.application.movie.mapper.toShowCreationInformation
import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
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


    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: UUID): Mono<MovieCreateShowResponse?> =
        movieService.getMovieById(id)
            .map { it.toMovieCreateShowSelection() }
}