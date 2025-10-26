package com.example.project_library.web;

import com.example.project_library.client.MovieSearchClient;
import com.example.project_library.dto.MovieSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie/admin/search")
public class MovieSearchAdminController {

    private final MovieSearchClient client;

    @PostMapping
    public String searchMovies(@ModelAttribute("search") MovieSearchDto dto, Model model) {
        var movies = client.search(dto);
        model.addAttribute("movies", movies);
        return "admin";
    }
}