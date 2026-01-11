package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface TheaterRepository : R2dbcRepository<TheaterEntity, UUID> {
}