package com.cli.fancy.cinevault.application.api.reservation.mapper

import com.cli.fancy.cinevault.application.api.reservation.dto.ReservationRequest
import com.cli.fancy.cinevault.application.api.reservation.dto.ReservationResponse
import com.cli.fancy.cinevault.domain.reservation.Reservation
import com.cli.fancy.cinevault.infrastructure.persistence.reservation.ReservationEntity

fun Reservation.toDto(): ReservationResponse = ReservationResponse(
    reservationId = requireNotNull(this.id) { "Reservation must be persisted before converting to DTO" },
    movieId = this.movieId,
    seatNumber = this.seatNumber,
    userId = this.userId,
)

fun ReservationRequest.toEntity(): ReservationEntity = ReservationEntity(
    userId = this.userId,
    seatNumber = this.seatNumber,
    theaterId = this.theaterId,
    movieId = this.movieId,
)

fun ReservationEntity.toDomain(): Reservation = Reservation(
    userId = this.userId,
    seatNumber = this.seatNumber,
    theaterId = this.theaterId,
    movieId = this.movieId,
)
