package com.example.project_library.client;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.MovieSearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movieSearch-client", url = "http://localhost:8082", path = "/movie/search")
public interface MovieSearchClient {

    @PostMapping
    List<MovieDto> search(@RequestBody MovieSearchDto dto);


}
