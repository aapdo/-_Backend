package org.example.bliss_be.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ForbiddenException extends RuntimeException {
    private final HttpStatus status;
    public ForbiddenException(String msg) {
        super(msg);
        this.status = HttpStatus.FORBIDDEN;
    }
}