package com.cli.fancy.movie_reservation_system.application.movie.dto

import java.util.*

data class MovieCreateShowResponse(
    val id: UUID,
    val title: String,
    val durationMinutes: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieCreateShowResponse) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (durationMinutes != other.durationMinutes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + durationMinutes.hashCode()
        return result
    }
}