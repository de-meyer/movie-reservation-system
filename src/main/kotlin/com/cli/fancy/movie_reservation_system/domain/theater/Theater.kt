package com.cli.fancy.movie_reservation_system.domain.theater

import java.util.UUID

data class Theater(
    val id: UUID,
    val name: String,
    val capacity: Int,
)
