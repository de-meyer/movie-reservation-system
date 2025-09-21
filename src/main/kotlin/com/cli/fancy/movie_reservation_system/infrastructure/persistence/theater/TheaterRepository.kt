package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TheaterRepository : JpaRepository<TheaterEntity, UUID> {
}