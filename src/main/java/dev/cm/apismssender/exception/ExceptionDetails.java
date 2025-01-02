package dev.cm.apismssender.exception;

import java.time.LocalDateTime;

public record ExceptionDetails(
        String message,
        LocalDateTime timestamp,
        int status,
        String exception) {
}
