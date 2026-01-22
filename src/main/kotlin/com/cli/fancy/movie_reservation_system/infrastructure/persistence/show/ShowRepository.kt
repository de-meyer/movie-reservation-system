package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import java.time.Instant
import java.util.*

interface ShowRepository : R2dbcRepository<ShowEntity, UUID> {
    fun findByDateGreaterThanEqual(date: Instant): Flux<ShowEntity>
    fun findByDateBetween(startDate: Instant, endDate: Instant): Flux<ShowEntity>
}
// TODO: update repositories from JPA -> R2DBC