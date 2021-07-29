package com.simulation.dice.handler;

import com.simulation.dice.exception.InternalServerException;
import com.simulation.dice.payload.CustomException;
import com.simulation.dice.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<CustomException> handleInvalidInput(InvalidInputException invalidInputException) {
        CustomException exception = new CustomException(invalidInputException.getCustomMessage(),
                HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<CustomException> handleInternalServerException(InternalServerException internalServerException) {
        CustomException exception = new CustomException(internalServerException.getCustomMessage(),
                HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

}
