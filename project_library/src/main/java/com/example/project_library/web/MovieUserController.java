package com.example.project_library.web;
import com.example.project_library.client.MovieUserClient;
import com.example.project_library.service.CommentService;
import com.example.project_library.service.MovieUserService;
import com.example.project_library.service.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieUserController {

    private final MovieUserClient client;
    private final MovieUserService movieUserService;
    private final PosterService posterService;

    @GetMapping("/user")
    public String getAllMovies(Model model) {
        var movies = client.getAll();
        model.addAttribute("movies", movies);
        return "user";
    }

//    @PostMapping
//    public String role() {
//        return "roles";
//    }

    @GetMapping
    public String role() {
        return "roles";
    }


    @GetMapping("/{id}/poster")
    public ResponseEntity<byte[]> getPoster(@PathVariable UUID id) {
        ResponseEntity<byte[]> response = posterService.getPoster(id);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(response.getBody());
        }
        return ResponseEntity.notFound().build();
    }

}



