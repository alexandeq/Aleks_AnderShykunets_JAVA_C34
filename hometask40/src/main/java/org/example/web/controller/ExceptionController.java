package org.example.web.controller;

import org.example.web.exc.AgeValidationException;
import org.example.web.exc.EmailValidationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    //если email не содержит "@", кидаем эту ошибку
    @ExceptionHandler(EmailValidationException.class)
    public String processUnexpected(){
        return "error";
    }

    //если возраст < 18, кидаем эту ошибку
    @ExceptionHandler(AgeValidationException.class)
    public String processAgeError(AgeValidationException exc, Model model){

        model.addAttribute("age", exc.getPersonDto().getAge());
        return "ageError";
    }

}
