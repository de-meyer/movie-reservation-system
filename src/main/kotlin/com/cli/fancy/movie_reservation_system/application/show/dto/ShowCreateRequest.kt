package com.cli.fancy.movie_reservation_system.application.show.dto

import java.time.Instant
import java.util.*

class ShowCreateRequest(
    val movieId: UUID,
    val theaterId: UUID,
    val date: Instant,
    val timestamp: Instant
) {
}