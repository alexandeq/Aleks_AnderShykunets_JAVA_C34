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
    public String getMovie(@PathVariable UUID id, Model model) {
        MovieDto movie = movieService.findById(id);
        List<CommentDto> comments = service.getComments(id);

        model.addAttribute("movie", movie);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new CommentDto());  // для формы
        return "comment"; // movie-details.html
    }

    //
    @PostMapping("/{movieId}/comment")
    public String addComment(@PathVariable UUID movieId,
                             @ModelAttribute("newComment") CommentDto dto) {
        service.addComment(movieId, dto);
        return "redirect:/movie/user/" + movieId;
    }

}
//
//    @PostMapping("/{movieId}/add")
//    public String addComment(@PathVariable UUID movieId,
//                             @ModelAttribute("comment") CommentDto dto) {
//        commentService.addComment(movieId, dto);
//        return "redirect:/comment/" + movieId; // редирект на список комментов фильма
//    }