package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.r2dbc.repository.R2dbcRepository
import java.util.*

interface MovieRepository : R2dbcRepository<MovieEntity, UUID> {

}