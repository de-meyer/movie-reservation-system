package com.cli.fancy.movie_reservation_system.infrastructure.persistence.user

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
class UserEntity private constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID = UUID.randomUUID()

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    var name: String = ""

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    var email: String = ""

    @Column(name = "role", nullable = false, length = Integer.MAX_VALUE)
    var role: String = "GUEST"

    constructor(name: String, email: String, role: String = "GUEST") : this() {
        this.name = name
        this.email = email
        this.role = role
    }

    override fun equals(other: Any?): Boolean = (other is UserEntity) && id == other.id
    override fun hashCode(): Int = id.hashCode()
}