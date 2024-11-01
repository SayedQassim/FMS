package com.ga.basic_auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)

public class InformationExistsException extends RuntimeException {
    public InformationExistsException(String message) {
        super(message);
    }
}
