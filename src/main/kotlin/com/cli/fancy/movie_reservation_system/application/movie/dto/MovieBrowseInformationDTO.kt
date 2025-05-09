package com.cli.fancy.movie_reservation_system.application.movie.dto

data class MovieBrowseInformationDTO (
    val name: String,
    val image: ByteArray,
    val url: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieBrowseInformationDTO) return false

        if (name != other.name) return false
        if (!image.contentEquals(other.image)) return false
        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + image.contentHashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}