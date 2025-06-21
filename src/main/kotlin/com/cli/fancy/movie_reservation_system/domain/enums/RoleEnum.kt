package com.cli.fancy.movie_reservation_system.domain.enums

enum class RoleEnum {
    ADMIN,
    USER,
    GUEST;

    companion object {
        fun fromString(role: String): RoleEnum? {
            return values().find { it.name.equals(role, ignoreCase = true) }
        }
    }