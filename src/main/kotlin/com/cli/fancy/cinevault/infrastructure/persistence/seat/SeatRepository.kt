package com.cli.fancy.cinevault.infrastructure.persistence.seat

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.util.*

interface SeatRepository : ReactiveCrudRepository<SeatEntity, UUID> {

    fun findByTheaterId(theaterId: UUID): Flux<SeatEntity>
}
