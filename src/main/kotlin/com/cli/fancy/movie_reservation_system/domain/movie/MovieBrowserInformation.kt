package com.cli.fancy.movie_reservation_system.domain.movie

data class MovieBrowserInformation(
    val name: String,
    val image: ByteArray,
    val url: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieBrowserInformation) return false

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
