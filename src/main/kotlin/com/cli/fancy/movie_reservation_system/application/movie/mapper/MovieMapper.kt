package com.cli.fancy.movie_reservation_system.application.movie.mapper

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreationRequest
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreationResponse
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
/*{
    fun toEntity(movieResponse: MovieResponse): MovieEntity
}*/