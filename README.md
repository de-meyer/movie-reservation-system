# movie-reservation-system

An application for end users to manage their seat reservations, get information about which movies
are currently playing, and get information about the movies that will be played in the future.
It is required to register to the system in order to make a reservation.

## API Documentation

This project includes automatic OpenAPI 3.0 specification generation and documentation.

### Quick Access

- **Swagger UI (Interactive)**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON (Standard)**: http://localhost:8080/v3/api-docs
- **OpenAPI JSON (Custom Endpoint)**: http://localhost:8080/api/openapi.json

### Frontend Integration

The OpenAPI specification can be used to:

- Generate TypeScript/JavaScript clients
- Auto-generate API documentation
- Create mock servers
- Import into Postman/Insomnia

Example:

```bash
# Generate TypeScript Axios client
npx @openapitools/openapi-generator-cli generate \
  -i http://localhost:8080/api/openapi.json \
  -g typescript-axios \
  -o ./frontend/src/generated/api
```

For detailed documentation, see [OPENAPI_INTEGRATION.md](OPENAPI_INTEGRATION.md).

