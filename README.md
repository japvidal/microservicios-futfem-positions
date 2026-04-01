# microservicios-futfem-positions

`microservicios-futfem-positions` is the backend service dedicated to football positions in the Tikitakas platform. It exposes the REST endpoints used to manage and retrieve the domain data associated with player positions, which can then be reused by player, squad, and matchday flows throughout the application.

The repository is built with Java 21, Spring Boot, Spring Data JPA, MySQL, Springdoc OpenAPI, and Maven Wrapper. Shared controller and service patterns come from `microservicios-common`, while Eureka and the gateway provide discovery and external access. This keeps the service lightweight while still fitting naturally into the microservice ecosystem.

Typical local execution:

```bash
./mvnw spring-boot:run
```

Gateway route:

- `/api/futfem/positions/**`

In `v0.1.0`, the repository includes Jenkins-based CI, Docker packaging, and gateway-aware Swagger configuration. As a result, the API documentation can be opened centrally through the gateway and still offer valid public routes for interactive testing.

This repository is intentionally focused and small. Its role is to provide a clean, reusable source of truth for position metadata, keeping that concern separate from player-specific or squad-specific logic.
