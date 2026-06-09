package com.chamo.chamowishes.exception;

import org.springframework.http.HttpStatus;

public class ResourceExistsException  extends ApiException {

    public ResourceExistsException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

}