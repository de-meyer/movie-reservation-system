package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "program")
data class ProgramEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val movieId: UUID,
    val date: Instant,
    val startTime: String,
    val price: Double
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProgramEntity) return false

        if (movieId != other.movieId) return false
        if (date != other.date) return false
        if (startTime != other.startTime) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = movieId.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + startTime.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }
}
