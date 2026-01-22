package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface ReservationRepository : ReactiveCrudRepository<ReservationEntity, UUID> {
}