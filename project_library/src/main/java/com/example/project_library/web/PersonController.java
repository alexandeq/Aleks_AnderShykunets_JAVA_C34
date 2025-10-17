package com.example.project_library.web;
import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import feign.FeignException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

        @GetMapping("/login")
        public String loginPage() {
            return "login"; // Thymeleaf login.html
        }

        @GetMapping("/register")
        public String registerPage(Model model) {
            model.addAttribute("user", new PersonDto());
            return "register";
        }

        @PostMapping("/register")
        public String register(@ModelAttribute PersonDto dto, Model model) {
            service.register(dto);
            model.addAttribute("message", "Пользователь успешно зарегистрирован!");
            return "success";
        }


    }



//@Controller
//@RequiredArgsConstructor
//public class PersonController {
//
//    private final PersonService service;
//
//    @GetMapping("/register")
//    public String registerForm(Model model) {
//        model.addAttribute("user", new PersonDto());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute("user") PersonDto dto, Model model) {
//        service.register(dto);
//        model.addAttribute("message", "Регистрация прошла успешно!");
//        return "success";
//    }
//
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//    @PostMapping("/login")
//    public String loginPost() {
//        return "login";
//    }
//




