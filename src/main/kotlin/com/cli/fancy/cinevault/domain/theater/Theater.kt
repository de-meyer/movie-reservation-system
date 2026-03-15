package com.cli.fancy.cinevault.domain.theater

import java.util.UUID

data class Theater(
    val id: UUID,
    val name: String,
    val capacity: Int,
)
