package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.program.ProgramId

data class Program(
    val id: ProgramId,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Program) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
