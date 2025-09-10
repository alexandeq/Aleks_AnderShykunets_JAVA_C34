package com.example.project_library.web;

import com.example.project_library.dto.ErrorDto;
import com.example.project_library.exc.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryExceptionController {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDto> handlerCommonException (CommonException exc){
            return ResponseEntity.status(400).body(exc.getErrorDto());

        }
    }

