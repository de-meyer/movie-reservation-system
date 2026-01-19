package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "users")
data class UserEntity(
    @Id
    var id: UUID = UUID.randomUUID(),

    @Column("name")
    var name: String = "",

    @Column("email")
    var email: String = "",

    @Column("role")
    var role: String = "GUEST",
)