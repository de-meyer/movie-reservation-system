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
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.*
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
        @AuthenticationPrincipal oauth2User: OAuth2AuthenticationToken,
        @Parameter(description = "Provider ID of the user", required = true)
        @PathVariable id: String
    ): Mono<UserResponse> = userService.findByProviderIdAndProvider(
        oauth2User.principal?.attributes["id"] as String,
        oauth2User.authorizedClientRegistrationId
    )
        .map { it.toDto() }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete current user", description = "Delete the currently authenticated user")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "User successfully deleted"),
            ApiResponse(responseCode = "404", description = "User not found")
        ]
    )
    fun deleteMe(@AuthenticationPrincipal oauth2User: OAuth2AuthenticationToken): Mono<Void> =
        userService.findByProviderIdAndProvider(
            oauth2User.principal?.attributes["id"] as String,
            oauth2User.authorizedClientRegistrationId
        ).flatMap { userService.deleteById(it.id!!) }

    @GetMapping("/me")
    @Operation(summary = "Get current user", description = "Retrieve the currently authenticated user's information")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved current user")
        ]
    )
    fun me(@AuthenticationPrincipal oauth2User: OAuth2AuthenticationToken): Mono<UserLoginResponse> =
        userService.findByProviderIdAndProvider(
            oauth2User.principal?.attributes["id"] as String,
            oauth2User.authorizedClientRegistrationId
        ).map { it.toLoginDto() }
}
