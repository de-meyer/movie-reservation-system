package com.cli.fancy.cinevault.application.api.theater.mapper

import com.cli.fancy.cinevault.application.api.theater.dto.TheaterResponse
import com.cli.fancy.cinevault.domain.theater.Theater
import com.cli.fancy.cinevault.infrastructure.persistence.theater.TheaterEntity

fun Theater.toDto(): TheaterResponse = TheaterResponse(
    id = this.id,
    name = this.name,
    capacity = this.capacity,
)

fun TheaterEntity.toTheater(): Theater = Theater(this.id, this.name, this.capacity)
