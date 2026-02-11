package com.cli.fancy.movie_reservation_system.application.api.config

import com.cli.fancy.movie_reservation_system.domain.user.UserService
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
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
        val oauth2Token = authentication as OAuth2AuthenticationToken
        val provider = oauth2Token.authorizedClientRegistrationId // z.B. "discord", "google", "github"
        val oauth2User = oauth2Token.principal as OAuth2User

        // Provider-spezifische Attribute extrahieren
        val (providerId, name, email, avatar) = extractUserInfo(provider, oauth2User)

        return userService.findOrCreateUser(providerId, provider, name, email, avatar)
            .then(
                RedirectServerAuthenticationSuccessHandler("http://localhost:3000/program")
                    .onAuthenticationSuccess(webFilterExchange, authentication)
            )
    }

    private fun extractUserInfo(provider: String, oauth2User: OAuth2User): UserInfo {
        return when (provider) {
            "discord" -> UserInfo(
                providerId = oauth2User.attributes["id"] as String,
                name = oauth2User.attributes["username"] as String,
                email = oauth2User.attributes["email"] as? String ?: "",
                avatar = oauth2User.attributes["avatar"] as? String ?: ""
            )

            "google" -> UserInfo(
                providerId = oauth2User.attributes["sub"] as String,
                name = oauth2User.attributes["name"] as String,
                email = oauth2User.attributes["email"] as? String ?: "",
                avatar = oauth2User.attributes["picture"] as? String ?: ""
            )

            "github" -> UserInfo(
                providerId = (oauth2User.attributes["id"] as Number).toString(),
                name = oauth2User.attributes["login"] as String,
                email = oauth2User.attributes["email"] as? String ?: "",
                avatar = oauth2User.attributes["avatar_url"] as? String ?: ""
            )

            else -> throw IllegalArgumentException("Unsupported OAuth2 provider: $provider")
        }
    }

    private data class UserInfo(
        val providerId: String,
        val name: String,
        val email: String,
        val avatar: String
    )
}
