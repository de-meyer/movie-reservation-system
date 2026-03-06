package com.cli.fancy.movie_reservation_system.application.api.theater.mapper

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.SeatResponse
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat.SeatEntity

fun SeatEntity.toSeatResponse(): SeatResponse = SeatResponse(
    id = this.id,
    row = this.rowLabel,
    number = this.seatNumber,
)