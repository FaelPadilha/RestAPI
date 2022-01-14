package br.com.faelpf.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e, WebRequest request) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                badRequest,
                ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")),
                e.getMessage(),
                e.getClass().getName(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(apiException, badRequest);

    }

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e, WebRequest request) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                notFound,
                ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")),
                e.getMessage(),
                e.getClass().getName(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(apiException, notFound);

    }

}
