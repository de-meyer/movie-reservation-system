package com.cli.fancy.movie_reservation_system.domain.movie

import java.util.UUID

data class MovieBrowserInformation(
    val title: String,
    val image: ByteArray,
    val id: UUID
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieBrowserInformation) return false

        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + id.hashCode()
        return result
    }

}
