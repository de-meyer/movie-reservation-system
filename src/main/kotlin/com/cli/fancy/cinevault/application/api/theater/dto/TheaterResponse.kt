package com.cli.fancy.cinevault.application.api.theater.dto

import java.util.UUID

class TheaterResponse(
    val id: UUID?,
    val name: String,
    val capacity: Number,
)
