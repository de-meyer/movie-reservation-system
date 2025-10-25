package com.cli.fancy.movie_reservation_system.application.show.mapper

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ShowMapper {
    fun toShow(showEntity: ShowEntity): Show
    fun toShowResponse(show: Show): ShowResponse
    fun toEntityFromCreateRequest(showCreateRequest: ShowCreateRequest): ShowEntity
}