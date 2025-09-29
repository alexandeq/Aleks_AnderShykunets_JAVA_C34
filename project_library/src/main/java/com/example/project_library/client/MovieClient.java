package com.example.project_library.client;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "movie-client", url = "http://localhost:8082", path = "/movie")
public interface MovieClient {

    @GetMapping("/all")
    List<MovieDto> getAll();

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable UUID id); //    MovieDto findById(@PathVariable UUID id);

    @PostMapping
    MovieDto save(@RequestBody MovieDto dto);

    @PostMapping("/search")
    List<MovieDto> search(@RequestParam("title") String title);

}
//    @PutMapping("/admin")
//    public MovieDto update(@RequestParam UUID id, @RequestBody MovieDto dto) {
//        return service.updateByIdByAdmin(id, dto);
//    }
