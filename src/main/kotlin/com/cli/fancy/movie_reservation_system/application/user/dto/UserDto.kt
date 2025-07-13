package com.cli.fancy.movie_reservation_system.application.user.dto

import java.util.*

data class UserDto(
    val id: UUID? = null,
    val name: String,
    val email: String,
    val role: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserDto) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (role != other.role) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + role.hashCode()
        return result
    }

}