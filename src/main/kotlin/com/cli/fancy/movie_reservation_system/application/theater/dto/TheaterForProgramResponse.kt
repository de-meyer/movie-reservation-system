package com.cli.fancy.movie_reservation_system.application.theater.dto

data class TheaterForProgramResponse(
    val name: String,
    val capacity: Number,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TheaterForProgramResponse) return false

        if (name != other.name) return false
        if (capacity != other.capacity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + capacity.hashCode()
        return result
    }
}
