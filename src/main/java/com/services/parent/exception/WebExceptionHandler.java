package com.services.parent.exception;


import com.services.parent.dto.common.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
public class WebExceptionHandler {
    private ResponseEntity handle(ApplicationException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(ex.getCode());
        error.setParams(ex.getParams());
        error.setStatus(ex.getStatus());
        error.setMessageKey(ex.getMessageKey());
        return  new ResponseEntity<>(error, HttpStatusCode.valueOf(ex.getStatus()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> exeptionHandler(IOException ex) {
        System.out.println(ex.getMessage());
        ApplicationException exception = new ApplicationException();
        return this.handle(exception);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> throwablehHandler(Throwable ex) {
        System.out.println(ex.getMessage());
        ApplicationException exception = new ApplicationException();
        return this.handle(exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> constraintViolationExceptionhHandler(ConstraintViolationException ex) {
        System.out.println(ex.getMessage());
        ApplicationException exception = new ApplicationException();
        return this.handle(exception);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> constraintViolationExceptionhHandler(ApplicationException exception) {
        return this.handle(exception);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> sqlExceptionhHandler(SQLException ex) {
        System.out.println(ex.getMessage());
        ApplicationException exception = new ApplicationException();
        return this.handle(exception);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityViolationExceptionhHandler(DataIntegrityViolationException ex) {
        System.out.println(ex.getMessage());
        ApplicationException exception = new ApplicationException();
        return this.handle(exception);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> rsSttatusExceptionHandler(ResponseStatusException ex) {
        System.out.println(ex.getMessage());
        return switch (ex.getStatusCode().value()) {
            case 404 -> handle(new NotFoundException());
            default -> {
                yield this.handle(new ApplicationException());
            }
        };
    }
}
