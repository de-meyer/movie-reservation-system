package com.cli.fancy.movie_reservation_system.api.user

import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<UserEntity, Long>