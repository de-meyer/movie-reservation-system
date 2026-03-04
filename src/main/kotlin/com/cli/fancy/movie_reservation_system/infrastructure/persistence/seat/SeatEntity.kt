package com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table(name = "theater")
data class SeatEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column("theater_id")
    var theaterId: UUID,

    @Column("name")
    var name: String,

    @Column("row_label")
    var rowLabel: String,

    @Column("seat_number")
    var seatNumber: Int,
)
