package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import jakarta.persistence.*
import java.util.*

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "movies")
@Access(AccessType.FIELD)
class MovieEntity private constructor() { // no-arg constructor for Hibernate/KAPT

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    val id: UUID = UUID.randomUUID()

    @Column(name = "title", nullable = false)
    var title: String = ""

    @Column(name = "description", nullable = false)
    var description: String = ""

    @Column(name = "release_year", nullable = false)
    var releaseYear: Int = 0

    @Column(name = "director", nullable = false)
    var director: String = ""

    @Column(name = "genre", nullable = false)
    var genre: String = ""

    @Column(name = "duration_minutes", nullable = false)
    var durationMinutes: Int = 0

    @Column(name = "rating", nullable = false)
    var rating: Double = 0.0

    @Column(name = "image", nullable = false)
    var image: ByteArray = ByteArray(0)

    /** Secondary constructor for convenient creation */
    constructor(
        title: String,
        description: String,
        releaseYear: Int,
        director: String,
        genre: String,
        durationMinutes: Int,
        rating: Double,
        image: ByteArray
    ) : this() {
        this.title = title
        this.description = description
        this.releaseYear = releaseYear
        this.director = director
        this.genre = genre
        this.durationMinutes = durationMinutes
        this.rating = rating
        this.image = image
    }

    override fun equals(other: Any?): Boolean =
        this === other || (other is MovieEntity && id == other.id)

    override fun hashCode(): Int = id.hashCode()
}