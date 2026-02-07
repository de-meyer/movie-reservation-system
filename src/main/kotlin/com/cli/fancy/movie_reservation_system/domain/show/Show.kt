package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class Show(
    val id: UUID,
    val theaterId: UUID,
    val movieId: UUID,
    val date: Instant
)