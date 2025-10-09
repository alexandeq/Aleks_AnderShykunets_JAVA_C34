package com.example.project_library.web;
import com.example.project_library.client.MovieUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieUserController {

    private final MovieUserClient client;

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
    


}




