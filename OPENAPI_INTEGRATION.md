# OpenAPI Integration

Dieses Projekt nutzt SpringDoc OpenAPI 3 zur automatischen Generierung und Bereitstellung der API-Dokumentation.

## Features

- Automatische OpenAPI 3.0 Spezifikationsgenerierung aus Spring WebFlux Controllern
- Swagger UI für interaktive API-Exploration
- Dedizierter Endpoint für OpenAPI JSON Export

## Verfügbare Endpoints

### Swagger UI (Interaktive Dokumentation)

```
http://localhost:8080/swagger-ui.html
```

- Bietet eine benutzerfreundliche Web-Oberfläche zum Testen der API
- Erlaubt direktes Ausführen von API-Requests aus dem Browser

### OpenAPI JSON Spezifikation (Standard)

```
http://localhost:8080/v3/api-docs
```

- Standard SpringDoc Endpoint
- Liefert die vollständige OpenAPI 3.0 Spezifikation im JSON-Format

### OpenAPI JSON Spezifikation (Custom Endpoint für Frontend)

```
http://localhost:8080/api/openapi.json
```

- Dedizierter Endpoint für Frontend-Anwendungen
- Pretty-printed JSON Format
- Keine Authentifizierung erforderlich

## Integration ins Frontend

Sie können die OpenAPI-Spezifikation in Ihrer Frontend-Anwendung verwenden:

### Beispiel mit TypeScript/JavaScript:

```typescript
// OpenAPI JSON abrufen
fetch('http://localhost:8080/api/openapi.json')
    .then(response => response.json())
    .then(openApiSpec => {
        console.log('OpenAPI Specification:', openApiSpec);
        // Nutzen Sie die Spec mit Tools wie Swagger UI, Redoc, oder OpenAPI Generator
    });
```

### Code-Generierung mit OpenAPI Generator:

```bash
# TypeScript Axios Client generieren
npx @openapitools/openapi-generator-cli generate \
  -i http://localhost:8080/api/openapi.json \
  -g typescript-axios \
  -o ./src/generated/api

# React Query Hooks generieren
npx @kubb/cli generate \
  --config kubb.config.ts \
  --input http://localhost:8080/api/openapi.json
```

## Konfiguration

Die OpenAPI-Konfiguration befindet sich in:

```
src/main/kotlin/com/cli/fancy/movie_reservation_system/application/api/config/OpenApiConfig.kt
```

Anpassbare Eigenschaften in `application.yaml`:

```yaml
springdoc:
  api-docs:
    enabled: true
    path: /v3/api-docs
  swagger-ui:
    enabled: true
    path: /swagger-ui.html
    operations-sorter: method
    tags-sorter: alpha
```

## API-Dokumentation erweitern

Verwenden Sie OpenAPI-Annotations in Ihren Controllern:

```kotlin
@RestController
@RequestMapping("/api/example")
@Tag(name = "Example", description = "Example API")
class ExampleController {

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID", description = "Retrieve an item by its ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Success"),
            ApiResponse(responseCode = "404", description = "Not found")
        ]
    )
    fun getById(
        @Parameter(description = "ID of the item", required = true)
        @PathVariable id: UUID
    ): Mono<ResponseEntity<ExampleResponse>> {
        // Implementation
    }
}
```

## Sicherheit

Die folgenden Endpoints sind **ohne Authentifizierung** zugänglich:

- `/v3/api-docs/**`
- `/swagger-ui/**`
- `/swagger-ui.html`
- `/webjars/**`
- `/api/openapi.json`

Dies ist in `AuthSecurityConfig.kt` konfiguriert.

## Abhängigkeiten

Die OpenAPI-Integration nutzt:

```kotlin
implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.7.0")
```

Diese Abhängigkeit beinhaltet:

- SpringDoc Core
- Swagger UI
- OpenAPI 3.0 Support
- WebFlux Integration

