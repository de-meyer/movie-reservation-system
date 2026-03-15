package com.cli.fancy.cinevault.domain.show

import com.cli.fancy.cinevault.application.api.show.mapper.toShow
import com.cli.fancy.cinevault.infrastructure.persistence.show.ShowRepository
import com.cli.fancy.cinevault.infrastructure.persistence.show.ShowsEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class ShowService(val showRepository: ShowRepository) {

    fun findAll(): Flux<Show> {
        return showRepository.findAll().map { it.toShow() }
    }

    fun createShow(showsEntity: ShowsEntity): Mono<Show> =
        showRepository.save(showsEntity)
            .map { it.toShow() }

    fun findById(id: UUID): Mono<Show> =
        showRepository.findById(id)
            .switchIfEmpty(Mono.error(NoSuchElementException("No user found with id: $id ")))
            .map { it.toShow() }
}
