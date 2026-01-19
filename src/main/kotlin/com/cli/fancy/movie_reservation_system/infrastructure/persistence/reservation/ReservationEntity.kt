package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "reservation")
data class ReservationEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column("user_id")
    var userId: UUID,

    @Column("seat_number")
    var seatNumber: Int,

    @Column("theater_id")
    var theaterId: UUID,

    @Column("movie_id")
    var movieId: UUID,
)