package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@Entity
@Table(name = "reservation")
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ReservationEntity) return false

        if (id != other.id) return false
        if (userId != other.userId) return false
        if (seatNumber != other.seatNumber) return false
        if (theaterId != other.theaterId) return false
        if (movieId != other.movieId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + userId.hashCode()
        result = 31 * result + seatNumber.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + movieId.hashCode()
        return result
    }
}
