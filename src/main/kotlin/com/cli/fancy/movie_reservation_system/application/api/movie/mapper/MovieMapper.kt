package com.cli.fancy.movie_reservation_system.application.api.movie.mapper

import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreationRequest
import com.cli.fancy.movie_reservation_system.application.api.movie.dto.MovieCreationResponse
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity

fun Movie.toMovieCreationResponse(): MovieCreationResponse = MovieCreationResponse(
    id = this.id,
    title = this.title,
    description = this.description,
    durationMinutes = this.durationMinutes,
    director = this.director,
    genre = this.genre,
    releaseYear = this.releaseYear,
    imageProfile = this.imageProfile,
    imageLandscape = this.imageLandscape,
)

fun Movie.toShowCreationInformation(): MovieCreateShowResponse = MovieCreateShowResponse(
    id = this.id,
    title = this.title,
    durationMinutes = this.durationMinutes,
)

fun MovieEntity.toMovieFromEntity(): Movie = Movie(
    id = this.id!!,
    title = this.title,
    description = this.description,
    durationMinutes = this.durationMinutes,
    director = this.director,
    genre = this.genre,
    releaseYear = this.releaseYear,
    imageProfile = this.imageProfile,
    imageLandscape = this.imageLandscape,
)

fun Movie.toBrowseInformationDto(): MovieBrowseResponse = MovieBrowseResponse(
    id = this.id,
    title = this.title,
)

fun Movie.toMovieCreateShowSelection(): MovieCreateShowResponse = MovieCreateShowResponse(
    id = this.id,
    title = this.title,
    durationMinutes = this.durationMinutes,
)

fun MovieCreationRequest.toEntity(): MovieEntity = MovieEntity(
    title = this.title,
    description = this.description,
    durationMinutes = this.durationMinutes,
    director = this.director,
    genre = this.genre,
    releaseYear = this.releaseYear,
    imageProfile = this.imageProfile,
    imageLandscape = this.imageLandscape,
)