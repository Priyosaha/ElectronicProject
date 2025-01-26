package com.electronic.store.exception;


import com.electronic.store.dtos.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        ApiResponseMessage message = ApiResponseMessage
                .builder()
                .message(exception.getCustomMessage())
                .success(true).status(HttpStatus.NOT_FOUND)
                .userId(exception.getUserId()).build();
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}
