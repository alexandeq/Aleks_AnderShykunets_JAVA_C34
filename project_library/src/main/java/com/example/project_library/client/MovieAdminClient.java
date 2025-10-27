package com.example.project_library.client;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PageDto;
import com.example.project_library.dto.PosterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@FeignClient(name = "movie-admin-client", url = "http://localhost:8082", path = "/movie/admin")
public interface MovieAdminClient {

    @PostMapping
    MovieDto create(@RequestBody MovieDto dto);

    @PutMapping("/{id}")
    MovieDto edit(@PathVariable("id") UUID id, @RequestBody MovieDto dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id);

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable UUID id);

    @GetMapping("/{id}/poster")
    ResponseEntity<byte[]> getPosterByAdmin(@PathVariable UUID id);

    @PostMapping(value = "/{id}/poster", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<PosterDto> addPoster(@PathVariable UUID id, @RequestPart("poster") MultipartFile poster);

    @PostMapping("/page")
    List<MovieDto> findPage(@RequestBody PageDto dto);

}
