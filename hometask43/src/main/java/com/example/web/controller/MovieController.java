package com.example.web.controller;
import com.example.web.domain.MovieDto;
import com.example.web.domain.MovieSearchDto;
import com.example.web.domain.PageDto;
import com.example.web.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping
    public String home(Model model) {

        var all = service.findAll();
        model.addAttribute("movies", all);

        return "index.html";
    }

    @PostMapping
    public String getMovie(@Valid MovieDto dto, Model model) {
        service.save(dto);
        model.addAttribute("movies", service.findAll());
        return "index.html";
    }

    @PostMapping("/search")
    public String search(MovieSearchDto dto, Model model){
        var result = service.searchByTitleOrRating(dto);
        model.addAttribute("movies",result);
        return "index.html";
    }

    @PostMapping("/page")
    public String findPage(PageDto dto, Model model){
        var result =  service.findPageable(dto);
        model.addAttribute("movies",result);
        return "index.html";
    }

}
