package com.example.project_movies.web;

import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final MovieService service;

    // POST /comments/{movieId}
    @PostMapping("/{movieId}")
    public CommentDto addComment(@PathVariable UUID movieId,
                                 @RequestBody CommentDto dto) {
        return service.addComment(movieId, dto);
    }

    // GET /comments/{movieId}
    @GetMapping("/{movieId}")
    public List<CommentDto> getComments(@PathVariable UUID movieId) {
        return service.getComments(movieId);
    }

}
