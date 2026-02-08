package com.cli.fancy.movie_reservation_system.application.api.user

import com.cli.fancy.movie_reservation_system.application.api.user.dto.UserResponse
import com.cli.fancy.movie_reservation_system.application.api.user.mapper.toDto
import com.cli.fancy.movie_reservation_system.domain.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*


@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
) {

    @GetMapping
    fun getUsers(): Flux<UserResponse> = userService.getAllUsers().map { it.toDto() }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): Mono<UserResponse> = userService.getUserById(id)
        .map { it.toDto() }


    @GetMapping("/me")
    fun me(@AuthenticationPrincipal oauth2User: OAuth2User): ResponseEntity<UserResponse> {
        val user = UserResponse(
            id = UUID.randomUUID(),
            name = oauth2User.getAttribute<String>("username") ?: "",
            email = oauth2User.getAttribute<String>("email") ?: "",
            role = "ADMIN"
        )
        return ResponseEntity.ok(user)
    }
}