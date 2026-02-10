package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.show.ShowSchedule

data class Program(
    val movie: Movie,
    val shows: List<ShowSchedule>
)
