package com.cli.fancy.movie_reservation_system.application.movie.mapper

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieCreateShowResponse
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieResponse
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MovieMapper {
    fun toDto(movie: Movie?): MovieResponse
    fun toShowCreationInformation(movie: Movie?): MovieCreateShowResponse
    fun toBrowseInformationDto(movie: Movie?): MovieBrowseResponse
    fun toEntity(movieResponse: MovieResponse): MovieEntity
    fun toMovie(movieEntity: MovieEntity): Movie
    fun toMovieCreateShowSelection(movie: Movie?): MovieCreateShowResponse
}