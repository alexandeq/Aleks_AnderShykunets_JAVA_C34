package org.example.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.web.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String home(Model model){
        return "home";
    }

    @PostMapping("/register")
    public String homeRegisterPage(@Valid PersonDto person, BindingResult result, Model model){

        if(result.hasErrors()){
            var fieldErrors = result.getFieldErrors();

            for (FieldError fieldError : fieldErrors ){
                model.addAttribute(fieldError.getField() + "Error", fieldError.getDefaultMessage());
            }

            model.addAttribute("login", person.getLogin());
            model.addAttribute("email", person.getEmail());
            model.addAttribute("age", person.getAge());

            return "home";
        }

        return "index";

    }
}
