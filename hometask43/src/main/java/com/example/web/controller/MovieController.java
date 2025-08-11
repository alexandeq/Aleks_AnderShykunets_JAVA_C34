package com.example.web.controller;
import com.example.web.domain.MovieDto;
import com.example.web.domain.MovieSearchDto;
import com.example.web.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @PostMapping
    public String movie(@Valid MovieDto dto, Model model) {
        service.save(dto);
        model.addAttribute("movies", service.findAll());
        return "index.html";
    }

    @PostMapping("/search")
    public String search(MovieSearchDto dto, Model model){
        var result = service.findByTitle(dto);
        model.addAttribute("movies",result);
        return "index.html";
    }

}
