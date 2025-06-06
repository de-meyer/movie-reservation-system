package com.cli.fancy.movie_reservation_system.application.movie

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseInformationDTO
import com.cli.fancy.movie_reservation_system.application.user.User
import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/movie")
class MovieController(val movieService: MovieService) {

    // Add your movie-related endpoints here
    // For example:
    @GetMapping("/browse")
    fun getAllMovies(): List<MovieBrowseInformationDTO> {
        return movieService.getAllMovies()
    }
    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: UUID): Movie? = movieService.getMovieById(id)
}