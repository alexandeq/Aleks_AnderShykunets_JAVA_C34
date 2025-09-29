package com.example.project_movies.web;

import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final MovieService service;

    // POST /comments/{movieId}
//    @PostMapping("/{id}/comment")
//    public String addComment(@PathVariable UUID id,
//                             @RequestParam String comment,
//                             @RequestParam int rating) {
//        service.addComment(id, comment, rating);
//        return "redirect:/movie/" + id;
//
//    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> addComment(
            @PathVariable UUID id,
            @RequestBody CommentDto dto) {

        CommentDto saved = service.addComment(id, dto);
        return ResponseEntity.ok(saved);
    }
    // GET /comments/{movieId}
    @GetMapping("/{movieId}")
    public List<CommentDto> getComments(@PathVariable UUID movieId) {
        return service.getComments(movieId);
    }

}
