package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.util.*

@Table("movies")
data class MovieEntity(
    @Id
    @Column("id")
    val id: UUID? = null, // null für neue Entities, wird von der DB generiert

    @Column("title")
    val title: String,

    @Column("description")
    val description: String,

    @Column("release_year")
    val releaseYear: Int,

    @Column("director")
    val director: String,

    @Column("genre")
    val genre: String,

    @Column("duration_minutes")
    val durationMinutes: Int,

    @Column("image_profile")
    val imageProfile: String,

    @Column("image_landscape")
    val imageLandscape: String
)