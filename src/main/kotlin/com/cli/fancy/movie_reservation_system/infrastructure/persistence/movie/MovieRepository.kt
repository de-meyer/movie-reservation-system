package com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie

import org.springframework.data.repository.CrudRepository

interface MovieRepository: CrudRepository<MovieEntity, Long> {
    fun findByTitle(title: String): MovieEntity?
    fun findByGenre(genre: String): List<MovieEntity>
    fun findByRating(rating: Double): List<MovieEntity>
}