package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.model.*
import com.cli.fancy.movie_reservation_system.api.user.PrincipalUser
import com.cli.fancy.movie_reservation_system.api.user.UserService
import com.cli.fancy.movie_reservation_system.utils.JwtService
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


    @PostMapping("/auth/oauth/discord")
    fun oAuth(@RequestBody oAuthLoginRequest: OAuthLoginRequest): ResponseEntity<String> {
        val user = userService.getUserByEmail( oAuthLoginRequest.email)
            ?: userService.registerUser(oAuthLoginRequest)
        val token = jwtService.generateToken(user)
        val cookie = ResponseCookie.from("jwt", token)
            .httpOnly(true)
            .secure(true) // Use only over HTTPS
            .path("/")
            .maxAge((7 * 24 * 60 * 60).toLong()) // 7 days
            .sameSite("Strict") // Prevent CSRF
            .build()

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body("Login successful")
    }

    @GetMapping("/me")
    fun me(@AuthenticationPrincipal user: PrincipalUser): ResponseEntity<PrincipalUser> {
        return ResponseEntity.ok(user)
    }
}