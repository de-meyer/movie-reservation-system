package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
data class ReservationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @NotNull
    val userId: UUID,
    @NotNull
    val seatNumber: String,
    @NotNull
    val theaterId: UUID,
    @NotNull
    val movieId: UUID,
)
