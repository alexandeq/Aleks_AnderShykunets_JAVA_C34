package com.example.project_movies.web;

import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.dto.PosterDto;
import com.example.project_movies.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieAdminController {

    private final MovieService service;
    private final ObjectMapper objectMapper;


    @PostMapping
    public MovieDto create(@RequestBody MovieDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public MovieDto edit(@PathVariable("id") UUID id, @RequestBody MovieDto dto) {
        return service.editByIdByAdmin(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PostMapping("/{id}/poster")
    public ResponseEntity<PosterDto> addPoster(
            @PathVariable UUID id,
            @RequestParam("poster") MultipartFile poster
    ) throws IOException {
        PosterDto dto = service.addOrUpdatePoster(id, poster);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/poster")
    public ResponseEntity<byte[]> getPoster(@PathVariable UUID id) {
        byte[] image = service.getPoster(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }
}
