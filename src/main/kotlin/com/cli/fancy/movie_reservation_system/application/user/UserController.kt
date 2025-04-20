package com.cli.fancy.movie_reservation_system.application.user

import com.cli.fancy.movie_reservation_system.application.auth.OAuthLoginRequest
import com.cli.fancy.movie_reservation_system.domain.user.UserService
import com.cli.fancy.movie_reservation_system.infrastructure.security.JwtService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class AuthController(private val userService: UserService, private val jwtService: JwtService) {

    @GetMapping
    fun getUsers(): List<PrincipalUser> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): PrincipalUser? = userService.getUserById(id)


    @GetMapping("/me")
    fun me(@AuthenticationPrincipal user: PrincipalUser): ResponseEntity<PrincipalUser> {
        return ResponseEntity.ok(user)
    }
}