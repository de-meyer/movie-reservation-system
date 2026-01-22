package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface TheaterRepository : ReactiveCrudRepository<TheaterEntity, UUID> {
}