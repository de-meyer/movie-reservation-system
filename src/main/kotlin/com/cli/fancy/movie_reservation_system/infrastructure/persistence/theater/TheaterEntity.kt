package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "theater")
data class TheaterEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column("name")
    var name: String = "",

    @Column("capacity")
    var capacity: Int = 0
)
