package com.example.hometask47_BL.web;

import com.example.hometask47_BL.dto.ErrorDto;
import com.example.hometask47_BL.exc.HotelCommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(HotelCommonException.class)
    public ResponseEntity<ErrorDto> handleException (HotelCommonException exc){
        var errorDto = new ErrorDto(exc.getErrorCode(), exc.getDetails());

        return ResponseEntity.status(400).body(errorDto);
    }
}
