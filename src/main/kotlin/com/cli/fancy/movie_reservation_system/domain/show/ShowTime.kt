package com.cli.fancy.movie_reservation_system.domain.show

import java.time.Instant
import java.util.UUID

data class ShowTime(
    val id: UUID,
    val date: Instant
) {
    companion object {
        fun from(show: Show): ShowTime {
            return ShowTime(
                id = show.id,
                date = show.date
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShowTime) return false

        if (id != other.id) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
