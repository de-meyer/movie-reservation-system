package com.cli.fancy.movie_reservation_system.application.api.show.dto

import java.util.*

data class ShowResponse(
    val id: UUID,
    val movieId: UUID,
    val theaterId: UUID,
    val date: String
)