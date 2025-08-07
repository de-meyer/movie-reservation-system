package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "program")
data class ShowEntity(
    @EmbeddedId
    val id: ShowId
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShowEntity) return false

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
}
