package com.masivian.test.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
public class ApiMessage {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private List<String> errors;

    public ApiMessage(final HttpStatus status, final String message, final List<String> errors) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.errors = errors;
    }

    public ApiMessage(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.errors = Collections.singletonList(ex.getLocalizedMessage());
    }

    public ApiMessage(HttpStatus status, String message, String error) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.errors = Collections.singletonList(error);
    }
}
