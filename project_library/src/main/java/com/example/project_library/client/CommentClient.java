package com.example.project_library.client;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "comment-client", url = "http://localhost:8082", path = "/comment")
public interface CommentClient {


//    @GetMapping("/{movieId}")
//    List<CommentDto> getComments(@PathVariable("movieId") UUID movieId);

    @GetMapping("/{id}")
    MovieDto getMovieDetails(@PathVariable UUID id);

    @PostMapping("/{movieId}/comment")
    CommentDto addComment(@PathVariable("movieId") UUID movieId, @RequestBody CommentDto dto);

//    @GetMapping("/{id}/poster")
//    ResponseEntity<byte[]> getPoster(@PathVariable("id") UUID id);



}