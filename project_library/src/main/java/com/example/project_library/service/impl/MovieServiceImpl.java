package com.example.project_library.service.impl;

import com.example.project_library.client.MovieClient;
import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieClient client;

    @Override
    public List<MovieDto> findAll() {
      return client.getAll();
    }

    @Override
    public MovieDto findById(UUID id) {
        return client.findById(id);
    }

    @Override
    public MovieDto create(MovieDto dto) {
        return client.create(dto);
    }
    @Override
    public MovieDto update(UUID id, MovieDto dto) {
        return client.edit(id, dto);
    }
    @Override
    public void delete(UUID id) {
        client.delete(id);
    }
}
