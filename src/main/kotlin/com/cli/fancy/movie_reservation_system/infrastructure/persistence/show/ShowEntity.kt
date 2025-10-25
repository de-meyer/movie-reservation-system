package com.cli.fancy.movie_reservation_system.infrastructure.persistence.show

import jakarta.persistence.Access
import jakarta.persistence.AccessType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.*

@Entity
@Table(name = "show")
@Access(AccessType.FIELD)
class ShowEntity private constructor() { // Hibernate only

    @Id
    val id: UUID = UUID.randomUUID()

    lateinit var movieId: UUID
    lateinit var theaterId: UUID
    lateinit var date: Instant

    constructor(movieId: UUID, theaterId: UUID, date: Instant) : this() {
        this.movieId = movieId
        this.theaterId = theaterId
        this.date = date
    }

    override fun equals(other: Any?): Boolean = (other is ShowEntity) && id == other.id
    override fun hashCode(): Int = id.hashCode()
}