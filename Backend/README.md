# Quiroga Law Office - Public Website API

Spring Boot REST API (backend only) for public website content.

## Endpoints

- `GET /api/articles`
- `GET /api/articles/{id}`
- `GET /api/team`
- `GET /api/team/{id}`
- `GET /api/success`
- `GET /api/success/{id}`

## Data Source

All data is in-memory and pre-populated in `ContentRepository`.

## Run

```bash
mvn spring-boot:run
```

Server default URL:

`http://localhost:8081`

## Example Call

```bash
curl http://localhost:8081/api/articles/1
```