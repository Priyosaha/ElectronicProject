package com.electronic.store.exception;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String customMessage;
    private String userId;
    public ResourceNotFoundException() {
        super("resource not found !!");
    }

    public ResourceNotFoundException(String message, String userId) {
        this.customMessage = message;
        this.userId = userId;
    }
}
