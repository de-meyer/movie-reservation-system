package com.cli.fancy.movie_reservation_system.application.api.program.dto

import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.show.ShowSchedule

data class ProgramResponse(
    val movie: Movie,
    val shows: List<ShowSchedule>,
)