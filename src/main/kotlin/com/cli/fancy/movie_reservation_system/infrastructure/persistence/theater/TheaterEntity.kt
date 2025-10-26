package com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "theater")
@Access(AccessType.FIELD)
class TheaterEntity private constructor() {
    @Id
    val id: UUID = UUID.randomUUID()

    @Column(name = "name")
    var name: String = ""

    @Column(name = "capacity")
    var capacity: Int = 0

    constructor(name: String, capacity: Int) : this() {
        this.name = name
        this.capacity = capacity
    }

    override fun equals(other: Any?): Boolean = (other is TheaterEntity) && id == other.id
    override fun hashCode(): Int = id.hashCode()
}