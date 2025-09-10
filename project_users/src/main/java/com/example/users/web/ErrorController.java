package com.example.users.web;

import com.example.users.dto.ErrorDto;
import com.example.users.exc.UserCommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(UserCommonException.class)
    public ResponseEntity<ErrorDto> handleException(UserCommonException exc){

        var errorDto =  new ErrorDto(exc.getCode(), exc.getMessage());

        return ResponseEntity.status(400)
                .body(errorDto);
    }
}
