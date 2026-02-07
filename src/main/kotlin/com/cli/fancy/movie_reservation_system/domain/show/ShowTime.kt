package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class ShowTime(
    val id: UUID,
    val date: Instant
)