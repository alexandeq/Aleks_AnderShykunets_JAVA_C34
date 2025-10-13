package com.example.project_library.service;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    CommentDto addComment(UUID movieId, CommentDto dto);

    MovieDto getMovieDetails(UUID id);

}
