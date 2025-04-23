package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "movies")
data class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,

    @Column(nullable = false)
    val title: String,

    val description: String? = null,

    val releaseYear: Int? = null,

    val director: String? = null,

    val genre: String? = null,

    val durationMinutes: Int? = null,

    val rating: Double? = null,

    val createdAt: LocalDateTime = LocalDateTime.now()
)
