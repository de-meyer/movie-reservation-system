package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.*

@Table(name = "show")
data class ShowEntity( // Hibernate only

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column("movie_id")
    val movieId: UUID,

    @Column("theater_id")
    val theaterId: UUID,

    @Column("date")
    val date: Instant
)
