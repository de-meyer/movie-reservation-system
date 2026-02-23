package com.cli.fancy.movie_reservation_system.application.api.user

import com.cli.fancy.movie_reservation_system.application.api.user.dto.UserLoginResponse
import com.cli.fancy.movie_reservation_system.application.api.user.dto.UserResponse
import com.cli.fancy.movie_reservation_system.application.api.user.mapper.toDto
import com.cli.fancy.movie_reservation_system.application.api.user.mapper.toLoginDto
import com.cli.fancy.movie_reservation_system.domain.user.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User management API")
class UserController(
    private val userService: UserService,
) {

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve all registered users")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved all users")
        ]
    )
    fun getUsers(): Flux<UserResponse> = userService.getAllUsers().map { it.toDto() }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by provider ID", description = "Retrieve a specific user by provider ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
            ApiResponse(responseCode = "404", description = "User not found")
        ]
    )
    fun getUserByProviderId(
        @AuthenticationPrincipal oauth2User: OAuth2User,
        @Parameter(description = "Provider ID of the user", required = true)
        @PathVariable id: String
    ): Mono<UserResponse> = userService.findByProviderIdAndProvider(
        oauth2User.attributes["id"] as String,
        "discord"
    )
        .map { it.toDto() }

    @GetMapping("/me")
    @Operation(summary = "Get current user", description = "Retrieve the currently authenticated user's information")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved current user")
        ]
    )
    fun me(@AuthenticationPrincipal oauth2User: OAuth2User): Mono<UserLoginResponse> =
        userService.findByProviderIdAndProvider(
            oauth2User.attributes["id"] as String,
            "discord"
        ).map { it.toLoginDto() }
}
