package com.cli.fancy.movie_reservation_system.application.user

import com.cli.fancy.movie_reservation_system.application.user.dto.UserDto
import com.cli.fancy.movie_reservation_system.application.user.mapper.UserMapper
import com.cli.fancy.movie_reservation_system.domain.user.UserService
import com.cli.fancy.movie_reservation_system.infrastructure.security.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
    private val jwtService: JwtService,
    private val userMapper: UserMapper
) {

    @GetMapping
    fun getUsers(): List<UserDto> = userService.getAllUsers().map { userMapper.toDto(it) }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): UserDto? = userService.getUserById(id).let { userMapper.toDto(it) }


    @GetMapping("/me")
    fun me(@AuthenticationPrincipal user: UserDto): ResponseEntity<UserDto> {
        return ResponseEntity.ok(user)
    }
}