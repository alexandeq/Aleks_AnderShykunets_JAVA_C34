package com.example.project_library.service;

import com.example.project_library.dto.MovieDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface MovieUserService {

    List<MovieDto> findAll();

   // ResponseEntity<byte[]> getPoster(UUID id);
}
