package com.cli.fancy.cinevault.application.api.theater.dto

import java.util.UUID

class SeatResponse(
    val id: UUID,
    val row: String,
    val number: Int,
)
