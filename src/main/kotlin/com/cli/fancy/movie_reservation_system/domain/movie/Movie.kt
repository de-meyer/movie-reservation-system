package com.cli.fancy.movie_reservation_system.domain.movie

import java.util.*

data class Movie(
    val id: UUID? = null,
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val director: String?,
    val genre: String?,
    val releaseYear: Int,
    val rating: Double?,
    val imageProfile: String?,
    val imageLandscape: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Movie) return false

        if (durationMinutes != other.durationMinutes) return false
        if (releaseYear != other.releaseYear) return false
        if (rating != other.rating) return false
        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (director != other.director) return false
        if (genre != other.genre) return false
        if (imageProfile != other.imageProfile) return false
        if (imageLandscape != other.imageLandscape) return false

        return true
    }

    override fun hashCode(): Int {
        var result = durationMinutes
        result = 31 * result + releaseYear
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + (director?.hashCode() ?: 0)
        result = 31 * result + (genre?.hashCode() ?: 0)
        result = 31 * result + (imageProfile?.hashCode() ?: 0)
        result = 31 * result + (imageLandscape?.hashCode() ?: 0)
        return result
    }

}
