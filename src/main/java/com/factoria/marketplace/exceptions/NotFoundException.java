package com.factoria.marketplace.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private String code;
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;

    }
}
