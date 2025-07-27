package com.example.web.controller;
import com.example.web.domain.MovieDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    private final List<MovieDto> movieList = new ArrayList<>();

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("movie", new MovieDto());
        model.addAttribute("movies", movieList);
        return "index";
    }

    @PostMapping("/movies")
    public String allMovies(
            @Valid @ModelAttribute("movie") MovieDto movie,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("movies", movieList);
            return "index";
        }

        movieList.add(movie);

        model.addAttribute("movie", new MovieDto());
        model.addAttribute("movies", movieList);
        return "index";
    }
}