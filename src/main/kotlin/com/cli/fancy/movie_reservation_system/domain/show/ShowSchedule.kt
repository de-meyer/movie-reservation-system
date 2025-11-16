package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class ShowSchedule(
    val id: UUID? = null,
    val theaterName: String,
    val date: Instant
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShowSchedule) return false

        if (id != other.id) return false
        if (theaterName != other.theaterName) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + theaterName.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }

}
