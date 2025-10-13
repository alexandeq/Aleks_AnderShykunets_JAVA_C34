package com.example.project_movies.web;

import com.example.project_movies.domain.PosterEntity;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.repository.MovieRepository;
import com.example.project_movies.repository.PosterRepository;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie/user")
public class MovieUserController {

    private final MovieService service;
    private final PosterRepository repo;


    @GetMapping("/all")
    public List<MovieDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable UUID id) {
        return service.findById(id);

    }

    @GetMapping("/{id}/poster")
    public ResponseEntity<byte[]> getPoster(@PathVariable UUID id) {
        PosterEntity poster = repo.findByMovieId(id).orElse(null);
        if (poster == null || poster.getImage() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(poster.getImage());
    }




}


