package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.time.Instant
import java.util.*

interface ShowRepository : ReactiveCrudRepository<ShowEntity, UUID> {
    fun findByDateGreaterThanEqual(date: Instant): Flux<ShowEntity>
    fun findByDateBetween(startDate: Instant, endDate: Instant): Flux<ShowEntity>
}
// TODO: update repositories from JPA -> R2DBC