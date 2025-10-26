package com.example.project_library.web;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.CommentService;
import com.example.project_library.service.MovieAdminService;
import com.example.project_library.service.MovieUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie/user")
public class CommentController {

    private final CommentService service;

        @GetMapping("/{id}")
        public String getMovieDetails(@PathVariable UUID id, Model model) {
            MovieDto movie = service.getMovieDetails(id);
            model.addAttribute("movie", movie);
            model.addAttribute("comments", movie.getComments());
            model.addAttribute("newComment", new CommentDto());
            return "comment";
        }


    @PostMapping("/{movieId}/comment")
    public String addComment(@PathVariable UUID movieId,
                             @ModelAttribute CommentDto commentDto) {

        service.addComment(movieId, commentDto);
        return "redirect:/movie/user/" + movieId;
    }


}




