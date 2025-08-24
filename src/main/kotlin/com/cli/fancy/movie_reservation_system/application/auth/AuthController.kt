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

@RestController
@RequestMapping("/auth")
class AuthController(private val userService: UserService, private val jwtService: JwtService) {

    @PostMapping("/oauth/discord")
    fun oAuth(@RequestBody userLoginRequest: UserLoginRequest): ResponseEntity<String> {
        val user = try {
            userService.getUserByEmail(userLoginRequest.email)
        } catch (e: NoSuchElementException) {
            userService.registerUser(userLoginRequest)
        }
        val token = jwtService.generateToken(user)
        val cookie = ResponseCookie.from("user_jwt", token)
            .httpOnly(true)
            .secure(true) // Use only over HTTPS
            .path("/")
            .maxAge((1 * 60 * 60).toLong()) // 1 hour
            .sameSite("Strict") // Prevent CSRF
            .build()

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body("Login successful")
    }

}