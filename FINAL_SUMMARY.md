# Final Project Summary — Quiroga Law Office Full-Stack Website

## What I Built

A full-stack web presence for **Quiroga Law Office, PLLC**, an immigration law firm. The project
delivers a professional single-page site backed by a REST API that serves dynamic
content—team members, blog articles, and client success stories—to the frontend without hardcoding
anything in the HTML.

A contact form lets visitors submit inquiries; the backend validates the input and appends each
submission to a server-side log file.

---

## How I Structured It

The workspace is split into two independently runnable directories:

```
quiroga-fullstack/
├── Backend/          # Spring Boot REST API (port 8081)
│   └── src/main/java/com/quiroga/lawapi/
│       ├── config/         WebConfig.java   (CORS)
│       ├── controller/     ArticleController, ContactController,
│       │                   SuccessController, TeamController
│       ├── model/          Article, TeamMember, SuccessStory
│       └── service/        ContentRepository  (in-memory data store)
└── Frontend/         # Vanilla HTML / CSS / JS (no build step needed)
    ├── index.html
    ├── css/style.css
    ├── js/main.js
    └── scss/           (source SCSS, compiled to style.css)
```


---

## Technologies Used

| Layer | Technology |
|---|---|
| Language (backend) | Java 21 |
| Framework | Spring Boot 3.x (Spring Web) |
| Build tool | Maven |
| Language (frontend) | HTML5, CSS3, Vanilla JavaScript (ES2020) |
| Styling | SCSS (compiled to plain CSS) |
| Fonts | Google Fonts — Lora + Open Sans |
| IDE | Visual Studio Code |

---

## Bugs Fixed

### Bug — Missing input validation in `ContactController` (real bug)

**File:** `Backend/src/main/java/com/quiroga/lawapi/controller/ContactController.java`

**Problem:** The `POST /api/contact` handler only validated the email address. An attacker (or
accidental request) could submit a form with a blank `name` or blank `message` and receive a 200
OK, producing a log entry that was empty or misleading.

**Fix:** Added explicit validation guards for both `name` and `message` before the email check.
Each failure writes a descriptive line to the log and returns `400 Bad Request` with a clear error
message.

---

### Bug — No input-length limits on contact form fields (possible bug)

**File:** `Backend/src/main/java/com/quiroga/lawapi/controller/ContactController.java`

**Problem:** A determined user could submit arbitrarily large payloads — a multi-megabyte `message`
body, an absurdly long `name`, or an oversized email string. This could bloat the log file, exhaust
memory during string processing, or cause issues with any future email integration.

**Fix:** Added three named constants (`MAX_NAME_LENGTH = 100`, `MAX_EMAIL_LENGTH = 254` per RFC 5321,
`MAX_MESSAGE_LENGTH = 2000`) and a length check for each field after the empty-check. Oversized
submissions are rejected with `400 Bad Request` and a clear message stating the allowed limit.

---

## What I Would Improve With More Time

1. **Replace the in-memory `ContentRepository` with a real database.**  
   A JPA/Hibernate setup with PostgreSQL (production) would allow content to be managed
   without redeploying the application. The controller and service interfaces would remain
   unchanged.

2. **Add a proper contact-form email integration.**  
   Instead of writing to a flat log file, use Spring Mail (or a transactional email provider like
   SendGrid) to send an actual email to the office inbox on every valid submission.

3. **Make CORS origins configurable via `application.properties`.**  
   Currently the allowed origins are hardcoded in `WebConfig`. Moving them to a
   `cors.allowed-origins` property would make it trivial to lock them down for production without
   changing Java source.

4. **Write automated tests.**  
   At minimum: `@WebMvcTest` slices for each controller (happy path + validation failures) covering
   all the length-limit and blank-field edge cases.



