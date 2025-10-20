package com.example.project_library.web;

import com.example.project_library.exc.CommonException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class LibraryExceptionController {

        @ExceptionHandler(CommonException.class)
        public String handleUserException(CommonException ex, Model model) {
            model.addAttribute("error", ex.getMessage());
            return "error";
        }

    }
