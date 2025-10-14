package com.example.project_library.service.impl;

import com.example.project_library.client.MovieUserClient;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieUserServiceImpl implements MovieUserService {

    private final MovieUserClient client;

    @Override
    public List<MovieDto> findAll() {
      return client.getAll();
    }



}
