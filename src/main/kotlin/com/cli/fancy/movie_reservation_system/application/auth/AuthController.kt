package com.cli.fancy.movie_reservation_system.application.auth

import com.cli.fancy.movie_reservation_system.application.user.dto.UserLoginRequest
import com.cli.fancy.movie_reservation_system.domain.user.UserService
import com.cli.fancy.movie_reservation_system.infrastructure.security.JwtService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService, private val jwtService: JwtService) {

    @PostMapping("/oauth/discord")
    fun oAuth(@RequestBody userLoginRequest: UserLoginRequest): Mono<ResponseEntity<String>> =
        userService.getUserByEmail(userLoginRequest.email)
            .onErrorResume(NoSuchElementException::class.java) {
                userService.registerUser(userLoginRequest)
            }
            .map { user ->
                val token = jwtService.generateToken(user)
                createAuthResponse(token)
            }

    private fun createAuthResponse(token: String): ResponseEntity<String> {
        val cookie = ResponseCookie.from("user_jwt", token)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(3600L)
            .sameSite("Strict")
            .build()

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body("Login successful")
    }
}