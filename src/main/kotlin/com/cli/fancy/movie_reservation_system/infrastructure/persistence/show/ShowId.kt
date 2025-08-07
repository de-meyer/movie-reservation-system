package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import jakarta.persistence.Embeddable
import java.time.Instant
import java.util.UUID

@Embeddable
data class ShowId(
    val movieId: UUID,
    val theaterId: UUID,
    val date: Instant
)