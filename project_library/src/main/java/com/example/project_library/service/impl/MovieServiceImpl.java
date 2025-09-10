package com.example.project_library.service.impl;

import com.example.project_library.client.MovieClient;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieClient client;

    @Override
    public List<MovieDto> getMovies() {
      return client.getAll();
    }
}
