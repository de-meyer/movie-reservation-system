package com.cli.fancy.movie_reservation_system.domain.show

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowId
import java.time.Instant
import java.util.UUID

data class Show(
    val id: UUID,
    val theaterId: UUID,
    val date: Instant
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Show

        if (id != other.id) return false
        if (theaterId != other.theaterId) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + theaterId.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
