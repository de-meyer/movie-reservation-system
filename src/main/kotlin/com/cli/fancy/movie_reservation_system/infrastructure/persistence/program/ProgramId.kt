package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import jakarta.persistence.Embeddable
import java.time.Instant
import java.util.UUID

@Embeddable
data class ProgramId(
    val movieId: UUID,
    val theaterId: UUID,
    val date: Instant
)