package com.cli.fancy.cinevault.application.api.theater.mapper

import com.cli.fancy.cinevault.application.api.theater.dto.SeatResponse
import com.cli.fancy.cinevault.domain.seat.Seat
import com.cli.fancy.cinevault.infrastructure.persistence.seat.SeatEntity

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
