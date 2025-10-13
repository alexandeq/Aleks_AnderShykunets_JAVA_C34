package com.example.project_movies.web;

import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final MovieService service;


    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentDto> addComment(
            @PathVariable UUID id,
            @RequestBody CommentDto dto) {

        CommentDto saved = service.addComment(id, dto);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/{id}")
    public MovieDto getMovieDetails(@PathVariable UUID id) {
        return service.getMovieDetails(id);
    }






}
