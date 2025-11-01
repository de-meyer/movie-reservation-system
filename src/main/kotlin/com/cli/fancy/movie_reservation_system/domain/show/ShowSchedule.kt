package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant

data class ShowSchedule(
    val theaterName: String,
    val date: Instant
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShowSchedule) return false

        if (theaterName != other.theaterName) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = theaterName.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
