package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant
import java.time.LocalDate
import java.util.*

interface ShowRepository : JpaRepository<ShowEntity, UUID> {
    override fun findAll(pageable: Pageable): Page<ShowEntity>
    fun findByDateBetween(startDate: Instant, endDate: Instant, pageable: Pageable): Page<ShowEntity>
}