package com.cli.fancy.movie_reservation_system.application.movie.mapper

import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieBrowseInformationDto
import com.cli.fancy.movie_reservation_system.application.movie.dto.MovieDto
import com.cli.fancy.movie_reservation_system.domain.movie.Movie
import com.cli.fancy.movie_reservation_system.domain.movie.MovieBrowserInformation
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MovieMapper {
    fun toDto(movie: Movie?): MovieDto
    fun toBrowseInformationDto(movieBrowserInformation: MovieBrowserInformation): MovieBrowseInformationDto
    fun toEntity(movieDto: MovieDto): MovieEntity
    fun toBrowserInformationDomain(movieEntity: MovieEntity): MovieBrowserInformation
    fun toMovie(movieEntity: MovieEntity): Movie
}