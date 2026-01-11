package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface ReservationRepository : R2dbcRepository<ReservationEntity, UUID> {
}