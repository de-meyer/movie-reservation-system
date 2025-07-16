package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieResponse
import java.time.Instant
import java.util.UUID

data class ProgramResponse(
    val id: UUID,
    val movieResponse: List<MovieResponse>,
    val startDate: Instant,
    val endDate: Instant
)