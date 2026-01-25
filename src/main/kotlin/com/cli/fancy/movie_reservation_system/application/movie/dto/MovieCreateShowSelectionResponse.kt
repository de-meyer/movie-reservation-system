package com.cli.fancy.movie_reservation_system.application.movie.dto

import java.util.UUID

data class MovieCreateShowSelectionResponse(
    val id: UUID,
    val title: String,
    val durationMinutes: Int,
)
