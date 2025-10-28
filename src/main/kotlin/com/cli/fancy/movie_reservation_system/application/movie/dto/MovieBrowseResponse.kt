package com.cli.fancy.movie_reservation_system.application.movie.dto

import java.util.*

data class MovieBrowseResponse(
    val title: String,
    val id: UUID
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieBrowseResponse) return false

        if (title != other.title) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

}