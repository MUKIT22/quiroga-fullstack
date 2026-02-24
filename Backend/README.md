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

## Sample API Output

### `GET /api/articles/1`

```json
{
	"id": 1,
	"title": "Understanding Personal Injury Claims",
	"slug": "understanding-personal-injury-claims",
	"summary": "Key steps to protect your rights after an accident.",
	"content": "After an accident, document everything, seek medical attention, and speak with legal counsel early.",
	"publishedAt": "2026-01-10"
}
```

### `GET /api/team/1`

```json
{
	"id": 1,
	"name": "Ana Quiroga",
	"role": "Founding Attorney",
	"bio": "Over 15 years representing families in immigration and civil matters.",
	"photoUrl": "https://example.com/images/ana-quiroga.jpg"
}
```

### `GET /api/success/2`

```json
{
	"id": 2,
	"title": "Family Reunification Approved",
	"clientName": "C. R.",
	"caseType": "Immigration",
	"story": "We built a complete petition package that led to approval and reunification within expected processing time.",
	"date": "2025-12-05"
}
```

## Git Log

```bash
git log --oneline --decorate
```

## Demo

```bash
mvn spring-boot:run
curl http://localhost:8081/api/articles/1
curl http://localhost:8081/api/team/1
curl http://localhost:8081/api/success/2
```