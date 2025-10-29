package com.cli.fancy.movie_reservation_system.application.movie.dto

data class MovieForProgramResponse(
    val title: String,
    val description: String,
    val durationMinutes: Int,
    val director: String,
    val genre: String,
    val releaseYear: Int,
    val rating: Double?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieForProgramResponse) return false

        if (durationMinutes != other.durationMinutes) return false
        if (releaseYear != other.releaseYear) return false
        if (rating != other.rating) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (director != other.director) return false
        if (genre != other.genre) return false

        return true
    }

    override fun hashCode(): Int {
        var result = durationMinutes
        result = 31 * result + releaseYear
        result = 31 * result + (rating?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + director.hashCode()
        result = 31 * result + genre.hashCode()
        return result
    }
}
