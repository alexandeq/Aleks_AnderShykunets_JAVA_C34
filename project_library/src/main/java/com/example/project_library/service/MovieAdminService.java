package com.example.project_library.service;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PosterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface MovieAdminService {

    MovieDto create(MovieDto dto) ;

    MovieDto update(UUID id, MovieDto dto);

    void delete(UUID id) ;

    MovieDto findById(UUID id);


}
