package com.cli.fancy.movie_reservation_system.application.show.mapper

import com.cli.fancy.movie_reservation_system.application.show.dto.ShowCreateRequest
import com.cli.fancy.movie_reservation_system.application.show.dto.ShowResponse
import com.cli.fancy.movie_reservation_system.domain.show.Show
import com.cli.fancy.movie_reservation_system.infrastructure.persistence.show.ShowEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ShowMapper {
    fun toDto(show: Show): ShowResponse
    fun toShowEntity(show: Show): ShowEntity
    fun toShow(showEntity: ShowEntity): Show
    fun toShowFromCreate(showCreateRequest: ShowCreateRequest): Show
}