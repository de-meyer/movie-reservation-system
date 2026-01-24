package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.time.Instant
import java.util.*

interface ShowRepository : ReactiveCrudRepository<ShowsEntity, UUID> {
    fun findByDateGreaterThanEqual(date: Instant): Flux<ShowsEntity>
    fun findByDateBetween(startDate: Instant, endDate: Instant): Flux<ShowsEntity>
}
// TODO: update repositories from JPA -> R2DBC