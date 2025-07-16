package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID? = null

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    var name: String

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    var email: String

    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    var role: String? = "GUEST"

}