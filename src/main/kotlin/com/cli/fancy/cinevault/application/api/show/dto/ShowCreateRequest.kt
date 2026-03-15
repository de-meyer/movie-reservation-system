package com.cli.fancy.cinevault.application.api.show.dto

import java.time.Instant
import java.util.*

data class ShowCreateRequest(
    val movieId: UUID,
    val theaterId: UUID,
    val date: Instant,
)
