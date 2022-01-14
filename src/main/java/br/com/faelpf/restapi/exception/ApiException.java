package br.com.faelpf.restapi.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final HttpStatus status;
    private final ZonedDateTime timestamp;
    private final String message;
    private final String devMessage;
    private final String path;

    public ApiException(HttpStatus status, ZonedDateTime timestamp, String message, String devMessage, String path) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.devMessage = devMessage;
        this.path = path;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public String getPath() {
        return path;
    }

}
