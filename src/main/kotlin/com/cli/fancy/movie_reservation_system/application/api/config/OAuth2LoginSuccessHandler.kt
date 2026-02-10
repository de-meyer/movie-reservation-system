package com.cli.fancy.movie_reservation_system.application.api.config

import com.cli.fancy.movie_reservation_system.domain.user.UserService
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.server.WebFilterExchange
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class OAuth2LoginSuccessHandler(
    private val userService: UserService
) : ServerAuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        webFilterExchange: WebFilterExchange,
        authentication: Authentication
    ): Mono<Void> {
        val oauth2User = authentication.principal as OAuth2User
        val id = oauth2User.attributes["id"] as String
        val name = oauth2User.attributes["username"] as String
        val email = oauth2User.attributes["email"] as String
        val avatar = oauth2User.attributes["avatar"] as String

        return userService.findOrCreateDiscordUser(id, name, email, avatar)
            .then(
                RedirectServerAuthenticationSuccessHandler("http://localhost:3000/program")
                    .onAuthenticationSuccess(webFilterExchange, authentication)
            )
    }
}
