package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class ShowSchedule(
    val id: UUID? = null,
    val theaterName: String,
    val date: Instant
)