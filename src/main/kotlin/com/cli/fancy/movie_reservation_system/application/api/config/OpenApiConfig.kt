package com.cli.fancy.movie_reservation_system.application.api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.OAuthFlow
import io.swagger.v3.oas.models.security.OAuthFlows
import io.swagger.v3.oas.models.security.Scopes
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.AntPathMatcher
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.method.HandlerMethod

@Configuration
class OpenApiConfig {

    @Value("\${server.port:8080}")
    private lateinit var serverPort: String

    // Verwende die zentral definierten öffentlichen Pfade
    private val publicPaths = SecurityConstants.PUBLIC_PATHS.toList()

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Movie Reservation System API")
                    .version("1.0.0")
                    .description("API documentation for the Movie Reservation System")
                    .contact(
                        Contact()
                            .name("API Support")
                            .email("support@movie-reservation.com")
                    )
                    .license(
                        License()
                            .name("Apache 2.0")
                            .url("https://www.apache.org/licenses/LICENSE-2.0.html")
                    )
            )
            .addServersItem(
                Server()
                    .url("http://localhost:$serverPort")
                    .description("Local Development Server")
            )
            .components(
                Components()
                    .addSecuritySchemes(
                        "DiscordOAuth2",
                        SecurityScheme()
                            .type(SecurityScheme.Type.OAUTH2)
                            .description("Discord OAuth2 Authentication - used for user login and access control")
                            .flows(
                                OAuthFlows()
                                    .authorizationCode(
                                        OAuthFlow()
                                            .authorizationUrl("https://discord.com/api/oauth2/authorize")
                                            .tokenUrl("https://discord.com/api/oauth2/token")
                                            .scopes(
                                                Scopes()
                                                    .addString("identify", "Read user identity information")
                                                    .addString("email", "Read user email address")
                                            )
                                    )
                            )
                    )
            )
        // Keine globale Security mehr - wird per OperationCustomizer hinzugefügt
    }

    /**
     * Fügt automatisch Security zu allen Endpoints hinzu, außer zu denen in publicPaths.
     * Dies entspricht der Konfiguration in AuthSecurityConfig.
     */
    @Bean
    fun securityOperationCustomizer(): OperationCustomizer {
        val pathMatcher = AntPathMatcher()

        return OperationCustomizer { operation: Operation, handlerMethod: HandlerMethod ->
            // Hole den Request-Pfad vom Controller
            val requestMapping = handlerMethod.beanType.getAnnotation(RequestMapping::class.java)
            val basePath = requestMapping?.value?.firstOrNull() ?: ""

            // Prüfe, ob der Pfad öffentlich ist
            val isPublic = publicPaths.any { pattern ->
                pathMatcher.match(pattern, basePath) ||
                        pathMatcher.match(pattern, "$basePath/**")
            }

            // Wenn nicht öffentlich, füge Security hinzu
            if (!isPublic) {
                operation.security = listOf(
                    SecurityRequirement().addList("DiscordOAuth2", listOf("identify", "email"))
                )
            } else {
                // Explizit leere Security für öffentliche Endpoints
                operation.security = emptyList()
            }

            operation
        }
    }
}

