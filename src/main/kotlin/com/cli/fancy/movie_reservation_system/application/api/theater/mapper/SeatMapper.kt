package com.cli.fancy.movie_reservation_system.application.api.theater.mapper

import com.cli.fancy.movie_reservation_system.application.api.theater.dto.SeatResponse
import com.cli.fancy.movie_reservation_system.domain.seat.Seat
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.seat.SeatEntity


fun SeatEntity.toSeat(): Seat = Seat(
    id = this.id,
    row = this.rowLabel,
    number = this.seatNumber,
)

fun Seat.toSeatResponse(): SeatResponse = SeatResponse(
    id = this.id,
    row = this.row,
    number = this.number,
)