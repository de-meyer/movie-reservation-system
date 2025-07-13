package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MovieRepository : JpaRepository<MovieEntity, UUID> {

}