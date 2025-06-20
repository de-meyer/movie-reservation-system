package com.cli.fancy.movie_reservation_system.infrastructure.persistence.program

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ProgramRepository: CrudRepository<ProgramEntity, UUID> {

}