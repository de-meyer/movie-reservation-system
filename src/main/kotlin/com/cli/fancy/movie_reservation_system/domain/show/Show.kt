package com.cli.fancy.movie_reservation_system.domain.show

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowId

data class Show(
    val id: ShowId,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Show) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
