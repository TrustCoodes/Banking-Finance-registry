package com.trustbycode.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class ResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<MessageError> clientNotFoundException(ClientNotFoundException notFoundException,
                                                                WebRequest webRequest){
        MessageError messageError = new MessageError(HttpStatus.NOT_FOUND, notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
    }

}