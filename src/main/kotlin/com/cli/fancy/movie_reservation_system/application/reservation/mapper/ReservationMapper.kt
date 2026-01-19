package com.cli.fancy.movie_reservation_system.application.reservation.mapper

import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationRequest
import com.cli.fancy.movie_reservation_system.application.reservation.dto.ReservationResponse
import com.cli.fancy.movie_reservation_system.domain.reservation.Reservation
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation.ReservationEntity

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
