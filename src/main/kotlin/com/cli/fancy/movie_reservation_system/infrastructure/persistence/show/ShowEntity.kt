package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.*

@Entity
@Table(name = "show")
data class ShowEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column(name = "movie_id")
    val movieId: UUID,
    @Column(name = "theater_id")
    val theaterId: UUID,
    val date: Instant
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShowEntity

        if (id != other.id) return false
        if (movieId != other.movieId) return false
        if (theaterId != other.theaterId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + movieId.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
