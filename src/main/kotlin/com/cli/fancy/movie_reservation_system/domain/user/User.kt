package com.cli.fancy.movie_reservation_system.domain.user

import java.util.*

data class User(val id: UUID? = null, val name: String, val role: String, val email: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (role != other.role) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + role.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

}
