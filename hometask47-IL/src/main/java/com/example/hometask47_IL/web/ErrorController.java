package com.example.hometask47_IL.web;

import com.example.hometask47_IL.dto.ErrorDto;
import com.example.hometask47_IL.exc.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDto> handleCommonException(CommonException exc) {
        return ResponseEntity.status(400).body(exc.getDetailDto());
    }
}

