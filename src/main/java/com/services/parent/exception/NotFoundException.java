package com.services.parent.exception;

public class NotFoundException extends ApplicationException {
    public NotFoundException() {
        this("Not Found Exception");
    }

    public NotFoundException(String messageKey) {
        this(messageKey, "404");
    }

    public NotFoundException(String messageKey, String code) {
        this(messageKey, code, 404);
    }

    public NotFoundException(String messageKey, String code, Integer status) {
        super(messageKey, code, status);
    }
}
