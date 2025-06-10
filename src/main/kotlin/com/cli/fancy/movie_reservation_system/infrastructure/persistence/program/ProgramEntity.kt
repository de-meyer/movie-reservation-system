package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "program")
data class ProgramEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val movieId: UUID,
    val date: Instant,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProgramEntity) return false

        if (movieId != other.movieId) return false
        if (date != other.date) return false
        return true
    }

    override fun hashCode(): Int {
        var result = movieId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
