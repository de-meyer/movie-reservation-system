package com.cli.fancy.movie_reservation_system.application.theater.mapper

import com.cli.fancy.movie_reservation_system.application.theater.dto.TheaterResponse
import com.cli.fancy.movie_reservation_system.domain.theater.Theater
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterEntity

fun Theater.toDto(): TheaterResponse = TheaterResponse(
    id = this.id,
    name = this.name,
    capacity = this.capacity,
)

/*
TODO: finish TheaterRequest
fun TheaterRequest.toEntity(): TheaterEntity = TheaterEntity(
    id = this.id,

)
*/
fun TheaterEntity.toTheater(): Theater = Theater(this.id, this.name, this.capacity)
