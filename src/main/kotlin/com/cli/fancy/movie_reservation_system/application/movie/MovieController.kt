package com.cli.fancy.movie_reservation_system.application.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.movie.mapper.MovieMapper
import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/movie")
class MovieController(val movieService: MovieService, val movieMapper: MovieMapper) {

    // Add your movie-related endpoints here
    // For example:
    @GetMapping("/browse")
    fun getAllMovies(): List<MovieBrowseResponse> {
        return movieService.getAllMovies().map { movieMapper.toBrowseInformationDto(it) }
    }

    @GetMapping("/createShowInformation")
    fun getAllMovieInformationsForShowCreation(): List<MovieCreateShowResponse> {
        return movieService.getAllMovies().map { movieMapper.toShowCreationInformation(it) }
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: UUID): MovieCreateShowResponse? =
        movieService.getMovieById(id).let { movieMapper.toMovieCreateShowSelection(it) }
}