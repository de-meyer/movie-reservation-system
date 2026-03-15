package com.cli.fancy.cinevault.domain.show

import java.time.Instant
import java.util.UUID

data class ShowSchedule(
    val id: UUID? = null,
    val theaterName: String,
    val date: Instant
)
