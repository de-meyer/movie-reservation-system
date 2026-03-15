package com.cli.fancy.cinevault.domain.seat

import java.util.*

data class Seat(
    val id: UUID,
    val row: String,
    val number: Int,
)
