package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

interface ReservationRepository : JpaRepository<ReservationEntity, UUID> {
}