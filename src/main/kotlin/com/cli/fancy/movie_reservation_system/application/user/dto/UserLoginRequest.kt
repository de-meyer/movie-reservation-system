package com.cli.fancy.movie_reservation_system.application.user.dto

data class UserLoginRequest(val name: String, val email: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserLoginRequest) return false

        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}
