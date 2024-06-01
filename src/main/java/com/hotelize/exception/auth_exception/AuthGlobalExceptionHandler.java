package com.hotelize.exception.auth_exception;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class AuthGlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> globalHandler(RuntimeException runtimeException) {

        return new ResponseEntity<>(createErrorMessage(runtimeException, ErrorType.INTERNAL_SERVER_ERROR)
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> authServiceHandler(AuthServiceException AuthManagerException){
        return new ResponseEntity<>(createErrorMessage(AuthManagerException, AuthManagerException.getErrorType()),
                AuthManagerException.getErrorType().getHttpStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> duclicateKeyHandler(ConstraintViolationException duplicateKeyException){
        return new ResponseEntity<>(createErrorMessage(duplicateKeyException,ErrorType.INTERNAL_ERROR)
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        List<String> fields = new ArrayList<>();
        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createErrorMessage(exception, ErrorType.BAD_REQUEST);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, ErrorType.BAD_REQUEST.getHttpStatus());
    }


    private ErrorMessage createErrorMessage(Exception exception,ErrorType errorType){
        System.out.println("Tüm hataların geçtiği nokta...: "+ exception.getMessage());
        return ErrorMessage.builder()
                .message(errorType.getMessage())
                .code(errorType.getCode())
                .build();
    }
}
