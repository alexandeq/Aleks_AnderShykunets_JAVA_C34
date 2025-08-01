package com.example.web.controller;

import com.example.web.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MovieService service;

    @GetMapping
    public String home(Model model) {

        var all = service.findAll();
        model.addAttribute("movies", all);

        return "index.html";
    }
}
