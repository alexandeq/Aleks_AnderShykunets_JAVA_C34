package com.example.project_library.web;

import com.example.project_library.client.CommentClient;
import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.CommentService;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie/user")
public class CommentController {

    private final CommentClient client;
    private final CommentService service;
    private final MovieService movieService;

    @GetMapping("/{id}")
    public String getMovie() {
//        MovieDto movie = movieService.findById(id);
//        List<CommentDto> comments = service.getComments(id);
//
//        model.addAttribute("movie", movie);
//        model.addAttribute("comments", comments);
//        model.addAttribute("newComment", new CommentDto()); // для формы
        return "admin"; // movie-details.html
    }

    //
    @PostMapping("/{id}/comment")
    public String addComment(@PathVariable UUID id,
                             @ModelAttribute("newComment") CommentDto dto) {
        service.addComment(id, dto);
        return "redirect:/movie/user/" + id; // перезагрузка страницы фильма
    }

}