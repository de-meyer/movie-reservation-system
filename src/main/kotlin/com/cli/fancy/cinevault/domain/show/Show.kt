package com.cli.fancy.cinevault.domain.show

import java.time.Instant
import java.util.UUID

data class Show(
    val id: UUID,
    val theaterId: UUID,
    val movieId: UUID,
    val date: Instant
)
