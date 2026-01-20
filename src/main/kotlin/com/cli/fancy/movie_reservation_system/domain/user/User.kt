package com.cli.fancy.movie_reservation_system.domain.user

import java.util.*

data class User(val id: UUID, val name: String, val role: String, val email: String)
