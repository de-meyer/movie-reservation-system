package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShowRepository : JpaRepository<ShowEntity, UUID> {
    override fun findAll(pageable: Pageable): Page<ShowEntity>
}