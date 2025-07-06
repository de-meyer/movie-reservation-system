package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "movies")
data class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @Column(nullable = false)
    val title: String,
    val description: String? = null,
    val releaseYear: Int? = null,
    val director: String? = null,
    val genre: String? = null,
    val durationMinutes: Int? = null,
    val rating: Double? = null,
    val image: ByteArray,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieEntity) return false

        if (releaseYear != other.releaseYear) return false
        if (durationMinutes != other.durationMinutes) return false
        if (rating != other.rating) return false
        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (director != other.director) return false
        if (genre != other.genre) return false
        if (!image.contentEquals(other.image)) return false
        if (createdAt != other.createdAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = releaseYear ?: 0
        result = 31 * result + (durationMinutes ?: 0)
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (director?.hashCode() ?: 0)
        result = 31 * result + (genre?.hashCode() ?: 0)
        result = 31 * result + image.contentHashCode()
        result = 31 * result + createdAt.hashCode()
        return result
    }
}
