package com.example.project_library.web;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping("/register")
    public String register(@ModelAttribute("user") PersonDto dto, Model model) {
        service.create(dto);
        model.addAttribute("message", "Регистрация прошла успешно!");
        return "success";
    }

    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("user", new PersonDto());
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

//



