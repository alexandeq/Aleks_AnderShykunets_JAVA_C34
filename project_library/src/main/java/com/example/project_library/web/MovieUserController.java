package com.example.project_library.web;
import com.example.project_library.client.MovieClient;
import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieUserController {

    private final MovieService service;
    private final MovieClient client;

    @GetMapping("/user")
    public String getAllMovies(Model model) {
        var movies = client.getAll();
        model.addAttribute("movies", movies);
        return "user";
    }

    @PostMapping
    public String test1() {
        return "roles";
    }

    @GetMapping
    public String test() {
        return "roles";
    }

    @PostMapping("/admin")
    public String admin() {
        return "admin";
    }






}




