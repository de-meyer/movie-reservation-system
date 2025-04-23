package com.cli.fancy.movie_reservation_system.application.movie

import com.cli.fancy.movie_reservation_system.domain.movie.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class MovieController(val movieService: MovieService) {

    // Add your movie-related endpoints here
    // For example:
     @GetMapping("/all")
     fun getAllMovies(): List<Movie> {
         return movieService.getAllMovies()
     }
}