package com.example.project_library.service.impl;

import com.example.project_library.client.CommentClient;
import com.example.project_library.dto.CommentDto;
import com.example.project_library.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentClient client;

    public CommentDto addComment(UUID movieId, CommentDto dto) {
        return client.addComment(movieId, dto);
    }

    public List<CommentDto> getComments(UUID movieId) {
        return client.getComments(movieId);
    }
}
