package com.example.project_movies.web;

import com.example.project_movies.dto.ErrorDto;
import com.example.project_movies.exc.MovieCommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorMovieController {

    @ExceptionHandler(MovieCommonException.class)
    public ResponseEntity<ErrorDto> handleException(MovieCommonException exc){

        var errorDto =  new ErrorDto(exc.getCode(), exc.getMessage());

        return ResponseEntity.status(400)
                .body(errorDto);
    }
}
