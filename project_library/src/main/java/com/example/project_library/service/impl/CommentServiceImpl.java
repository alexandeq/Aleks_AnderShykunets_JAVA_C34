package com.example.project_library.service.impl;

import com.example.project_library.client.CommentClient;
import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentClient client;


    public CommentDto addComment(UUID movieId, CommentDto dto) {
        return client.addComment(movieId, dto);
    }

    public MovieDto getMovieDetails(UUID id){
        return client.getMovieDetails(id);
    }



}