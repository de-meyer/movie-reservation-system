package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table(name = "users")
data class UserEntity(
    @Id
    var id: UUID? = null,

    @Column("provider_id")
    var providerId: String,

    @Column("provider")
    var provider: String = "discord",

    @Column("name")
    var name: String = "",

    @Column("email")
    var email: String = "",

    @Column("avatar")
    var avatar: String = "",

    @Column("role")
    var role: String = "GUEST",
)
