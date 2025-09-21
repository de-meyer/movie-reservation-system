package com.cli.fancy.movie_reservation_system.domain.theater

import java.util.UUID

data class Theater(
    val id: UUID? = null,
    val name: String,
    val capacity: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Theater) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (capacity != other.capacity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + capacity
        return result
    }
}
