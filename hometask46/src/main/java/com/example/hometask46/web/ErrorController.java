package com.example.hometask46.web;

import com.example.hometask46.dto.ErrorDto;
import com.example.hometask46.exception.CourseNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCourseNotFoundException() {
        return ResponseEntity.status(404).body(new ErrorDto("Course not found"));
    }

}