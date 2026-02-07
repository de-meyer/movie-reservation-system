package com.cli.fancy.movie_reservation_system.domain.program

import com.cli.fancy.movie_reservation_system.application.api.movie.mapper.toMovieFromEntity
import com.cli.fancy.movie_reservation_system.application.api.show.mapper.toShow
import com.cli.fancy.movie_reservation_system.application.api.theater.mapper.toTheater
import com.cli.fancy.movie_reservation_system.domain.show.ShowSchedule
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.movie.MovieRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowRepository
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.theater.TheaterRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Instant
import java.time.temporal.ChronoUnit


@Service
class ProgramService(
    val movieRepository: MovieRepository,
    val showRepository: ShowRepository,
    val theaterRepository: TheaterRepository,
) {

    fun getDaySpecificProgramList(date: Instant): Flux<Program> {

        val startOfDay = date.truncatedTo(ChronoUnit.DAYS)
        val endOfDay = startOfDay.plus(1, ChronoUnit.DAYS)

        return showRepository.findByDateBetween(startOfDay, endOfDay)
            .map { it.toShow() }
            .collectList()
            .flatMapMany { shows ->
                if (shows.isEmpty()) {
                    return@flatMapMany Flux.empty()
                }

                // Get unique movie and theater IDs
                val movieIds = shows.map { it.movieId }.toSet()
                val theaterIds = shows.map { it.theaterId }.toSet()

                // Fetch movies and theaters in parallel
                val moviesMono = movieRepository.findAllById(movieIds)
                    .map { it.toMovieFromEntity() }
                    .collectMap({ it.id }, { it })

                val theatersMono = theaterRepository.findAllById(theaterIds)
                    .map { it.toTheater() }
                    .collectMap({ it.id }, { it })

                // Combine results
                Mono.zip(moviesMono, theatersMono)
                    .flatMapMany { tuple ->
                        val movies = tuple.t1
                        val theaters = tuple.t2

                        // Group shows by movie and create programs
                        val programs = shows.groupBy { it.movieId }.mapNotNull { (movieId, movieShows) ->
                            val movie = movies[movieId] ?: return@mapNotNull null

                            val showSchedules = movieShows.mapNotNull { show ->
                                val theater = theaters[show.theaterId] ?: return@mapNotNull null
                                ShowSchedule(
                                    id = show.id,
                                    theaterName = theater.name,
                                    date = show.date
                                )
                            }

                            if (showSchedules.isEmpty()) return@mapNotNull null

                            Program(
                                movie = movie,
                                shows = showSchedules.sortedBy { it.date }
                            )
                        }

                        Flux.fromIterable(programs)
                    }
            }
    }

    fun getProgramList(date: Instant): Flux<Program> =
        showRepository.findByDateGreaterThanEqual(date)
            .collectList()
            .flatMapMany { shows ->
                if (shows.isEmpty()) {
                    return@flatMapMany Flux.empty()
                }
                // Get unique movie and theater IDs
                val movieIds = shows.map { it.movieId }.toSet()
                val theaterIds = shows.map { it.theaterId }.toSet()

                // Fetch movies and theaters in parallel
                val moviesMono = movieRepository.findAllById(movieIds)
                    .map { it.toMovieFromEntity() }
                    .collectMap({ it.id }, { it })

                val theatersMono = theaterRepository.findAllById(theaterIds)
                    .map { it.toTheater() }
                    .collectMap({ it.id }, { it })

                // Combine results
                Mono.zip(moviesMono, theatersMono)
                    .flatMapMany { tuple ->
                        val movies = tuple.t1
                        val theaters = tuple.t2

                        // Group shows by movie and create programs
                        val programs = shows.groupBy { it.movieId }.mapNotNull { (movieId, movieShows) ->
                            val movie = movies[movieId] ?: return@mapNotNull null

                            val showSchedules = movieShows.mapNotNull { show ->
                                val theater = theaters[show.theaterId] ?: return@mapNotNull null
                                ShowSchedule(
                                    id = show.id,
                                    theaterName = theater.name,
                                    date = show.date
                                )
                            }

                            if (showSchedules.isEmpty()) return@mapNotNull null

                            Program(
                                movie = movie,
                                shows = showSchedules.sortedBy { it.date }
                            )
                        }

                        Flux.fromIterable(programs)
                    }
            }
}