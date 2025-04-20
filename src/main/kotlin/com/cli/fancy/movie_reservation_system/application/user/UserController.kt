package com.cli.fancy.movie_reservation_system.application.user

import com.cli.fancy.movie_reservation_system.domain.user.UserService
import com.cli.fancy.movie_reservation_system.infrastructure.security.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService, private val jwtService: JwtService) {

    @GetMapping
    fun getUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? = userService.getUserById(id)


    @GetMapping("/me")
    fun me(@AuthenticationPrincipal user: User): ResponseEntity<User> {
        return ResponseEntity.ok(user)
    }
}