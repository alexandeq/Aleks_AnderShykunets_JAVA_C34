package com.example.project_movies.web;

import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.dto.MovieSearchDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;

    @PostMapping
    public MovieDto create(@RequestBody MovieDto dto){
        return service.save(dto);
    }

    @GetMapping("/all")
    public List<MovieDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable UUID id) {
        return service.findById(id);

    }

    @PutMapping("/{id}")
    public MovieDto edit(@PathVariable("id") UUID id, @RequestBody MovieDto dto) {
        return service.editByIdByAdmin(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }


}
