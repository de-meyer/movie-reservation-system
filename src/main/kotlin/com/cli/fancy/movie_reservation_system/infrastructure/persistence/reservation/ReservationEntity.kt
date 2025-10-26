package com.cli.fancy.movie_reservation_system.infrastructure.persistence.reservation

import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "reservation")
@Access(AccessType.FIELD)
class ReservationEntity private constructor() {
    @Id
    val id: UUID = UUID.randomUUID()

    @Column(name = "user_id")
    lateinit var userId: UUID

    @Column(name = "seat_number")
    lateinit var seatNumber: String

    @Column(name = "theater_id")
    lateinit var theaterId: UUID

    @Column(name = "movie_id")
    lateinit var movieId: UUID

    constructor(userId: UUID, seatNumber: String, showEntity: ShowEntity) : this() {
        this.userId = userId
        this.seatNumber = seatNumber
        this.theaterId = showEntity.theaterId
        this.movieId = showEntity.movieId
    }

    override fun equals(other: Any?): Boolean = (other is ReservationEntity) && id == other.id
    override fun hashCode(): Int = id.hashCode()

}
