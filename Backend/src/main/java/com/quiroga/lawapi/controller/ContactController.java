package com.quiroga.lawapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final String LOG_FILE = "contact.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    // Basic email validation: must have something@something.tld
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    @PostMapping
    public ResponseEntity<Map<String, String>> handleContactForm(
            @RequestBody Map<String, String> body) {

        String name    = body.getOrDefault("name",    "").trim();
        String email   = body.getOrDefault("email",   "").trim();
        String message = body.getOrDefault("message", "").trim();

        String timestamp = LocalDateTime.now().format(FORMATTER);

        // --- Validate name ------------------------------------------------
        if (name.isEmpty()) {
            writeLog("[" + timestamp + "] Submission failed – name is blank");
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Name is required."));
        }

        // --- Validate email -----------------------------------------------
        if (email.isEmpty() || !EMAIL_PATTERN.matcher(email).matches()) {
            writeLog("[" + timestamp + "] Submission failed – missing or invalid email");
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Missing or invalid email address."));
        }

        // --- Validate message ---------------------------------------------
        if (message.isEmpty()) {
            writeLog("[" + timestamp + "] Submission failed – message is blank (" + email + ")");
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Message cannot be empty."));
        }

        // --- Log successful submission -------------------------------------
        String entry = "[" + timestamp + "] " + name
                + " (" + email + "): \""
                + message + "\"";
        writeLog(entry);

        return ResponseEntity.ok(
                Map.of("message", "Your message has been received. We will be in touch shortly."));
    }

    // -------------------------------------------------------------------------
    // Appends a single line to contact.log (creates the file if needed)
    // -------------------------------------------------------------------------
    private void writeLog(String line) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            pw.println(line);
        } catch (IOException e) {
            System.err.println("Could not write to contact.log: " + e.getMessage());
        }
    }
}
