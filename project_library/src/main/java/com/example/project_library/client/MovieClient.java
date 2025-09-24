package com.example.project_library.client;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "movie-client", url = "http://localhost:8082", path = "/movie")
public interface MovieClient {

    @GetMapping
    List<MovieDto> getAll();

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable("id") UUID id); //    MovieDto findById(@PathVariable UUID id);

    @PostMapping
    MovieDto save(@RequestBody MovieDto dto);

    @PostMapping("/{id}/comments")
    CommentDto addComment(@PathVariable UUID id, @RequestBody CommentDto dto);

    @GetMapping("/{id}/comments")
    List<CommentDto> getComments(@PathVariable UUID id);


}
//    @PutMapping("/admin")
//    public MovieDto update(@RequestParam UUID id, @RequestBody MovieDto dto) {
//        return service.updateByIdByAdmin(id, dto);
//    }
