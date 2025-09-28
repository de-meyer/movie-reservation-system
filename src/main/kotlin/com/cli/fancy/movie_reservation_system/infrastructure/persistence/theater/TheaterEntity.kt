package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "theater")
data class TheaterEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val name: String,
    val capacity: Int? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TheaterEntity) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (capacity != other.capacity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + (capacity ?: 0)
        return result
    }
}