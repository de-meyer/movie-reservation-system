package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "program")
data class ProgramEntity(
    @EmbeddedId
    val id: ProgramId
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProgramEntity) return false

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
}
