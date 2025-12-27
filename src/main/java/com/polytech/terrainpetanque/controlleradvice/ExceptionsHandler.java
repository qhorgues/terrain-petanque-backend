package com.polytech.terrainpetanque.controlleradvice;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class handle the exceptions in the REST API.
 */
@ControllerAdvice
public class ExceptionsHandler {

    /**
     * This method handle generic exception.
     *
     * @param exception The generic exception.
     * @return Return the error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception) {
        return new ResponseEntity<>("{\"error\":\"Bad request\", \"code\":400}", HttpStatus.BAD_REQUEST);
    }



    /**
     * This method handle not found exception.
     *
     * @param notFoundException The not found exception.
     * @return Return the error message.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<String>("{\"error\":\"Not found\", \"code\":404}", HttpStatus.NOT_FOUND);
    }

}
