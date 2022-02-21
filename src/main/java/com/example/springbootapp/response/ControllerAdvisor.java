package com.example.springbootapp.response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.persistence.EntityNotFoundException;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(EntityNotFoundException notFoundException) {
        return ErrorResponse.builder()
                .message(notFoundException.getMessage())
                .status(NOT_FOUND)
                .timestamp(now())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerInternalError(ConstraintViolationException constraintViolationException) {
        return ErrorResponse.builder()
                .message(constraintViolationException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(now())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ErrorResponse.builder()
                .message(methodArgumentNotValidException.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(now())
                .build();
    }
}
