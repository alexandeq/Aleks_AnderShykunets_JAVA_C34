package org.example.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.web.dto.PersonDto;
import org.example.web.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final ProfileService profileService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("personprofile", new PersonDto());
        return "home";
        }

    @PostMapping("/register")
    public String homeRegisterPage(@Valid @ModelAttribute(name = "personprofile") PersonDto person, BindingResult result){
        if(result.hasErrors()){
            var fieldErrors = result.getFieldErrors();
            return "home";
        }

        profileService.process(person);
        return "index";

    }
}