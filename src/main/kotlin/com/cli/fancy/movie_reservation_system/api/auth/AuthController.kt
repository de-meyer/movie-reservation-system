package com.cli.fancy.movie_reservation_system.api.auth

import com.cli.fancy.movie_reservation_system.api.model.*
import com.cli.fancy.movie_reservation_system.api.user.User
import com.cli.fancy.movie_reservation_system.api.user.UserService
import com.cli.fancy.movie_reservation_system.utils.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AuthController(private val userService: UserService, private val jwtUtil: JwtUtil) {

    @GetMapping
    fun getUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? = userService.getUserById(id)


    @PostMapping("/auth/oauth/discord")
    fun oAuth(@RequestBody oAuthLoginRequest: OAuthLoginRequest): ResponseEntity<OAuthLoginResponse> {
        val user = userService.getUserByEmail( oAuthLoginRequest.email)
            ?: userService.registerUser(oAuthLoginRequest)
        val token = jwtUtil.generateToken(user.email)
        return ResponseEntity.ok(OAuthLoginResponse(token))
    }

    @GetMapping("/me")
    fun me(@RequestHeader("Authorization") token: String): ResponseEntity<User> {
        val jwt = token.replace("Bearer ", "")
        if (!jwtUtil.validateToken(jwt)) return ResponseEntity.status(401).build()
        val username = jwtUtil.getEmailFromToken(jwt)
        val user = userService.getUserByEmail(username)
        return ResponseEntity.ok(user)
    }
}