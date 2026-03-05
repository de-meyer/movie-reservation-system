package com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface SeatRepository : ReactiveCrudRepository<SeatEntity, UUID>