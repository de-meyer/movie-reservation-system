package com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface SeatRepository : ReactiveCrudRepository<SeatEntity, UUID> {

    fun findByTheaterId(theaterId: UUID): Flux<SeatEntity>
}