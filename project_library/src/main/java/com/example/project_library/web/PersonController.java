package com.example.project_library.web;
import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.exc.CommonException;
import com.example.project_library.service.PersonService;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

//    @GetMapping("/login")
//    public String loginPage(HttpServletRequest request, Model model) {
//        Object error = request.getAttribute("error");
//        if (error != null) {
//            model.addAttribute("error", error.toString());
//        }
//        return "login"; // login.html
//    }



    //



    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        Object sessionError = request.getSession().getAttribute("LOGIN_ERROR");
        if (sessionError != null) {
            model.addAttribute("error", sessionError.toString());
            request.getSession().removeAttribute("LOGIN_ERROR");
        }
        return "login";
    }


        @GetMapping("/register")
        public String registerPage(Model model) {
            model.addAttribute("user", new PersonDto());
            return "register";
        }


        @PostMapping("/register")
        public String register(@ModelAttribute PersonDto dto, Model model) {
            try {
            service.register(dto);
            model.addAttribute("message", "Пользователь успешно зарегистрирован!");
            return "success";
            } catch (RuntimeException ex) {
                model.addAttribute("error", ex.getMessage());
                model.addAttribute("user", dto);
                return "register";
            }
        }


         @GetMapping("/error")
        public String errorPage(HttpServletRequest request, Model model) {
            Object error = request.getAttribute("error");
            if (error != null) model.addAttribute("error", error.toString());
            return "error";
        }



}
