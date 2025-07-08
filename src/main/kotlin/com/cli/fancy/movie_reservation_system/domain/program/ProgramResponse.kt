package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieDto
import java.time.Instant
import java.util.UUID

data class ProgramResponse(
    val id: UUID,
    val movieDto: List<MovieDto>,
    val startDate: Instant,
    val endDate: Instant
)