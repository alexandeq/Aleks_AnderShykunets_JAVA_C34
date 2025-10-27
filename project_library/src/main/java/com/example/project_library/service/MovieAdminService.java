package com.example.project_library.service;

import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PageDto;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface MovieAdminService {

    MovieDto create(MovieDto dto) ;

    MovieDto update(UUID id, MovieDto dto);

    void delete(UUID id) ;

    MovieDto findById(UUID id);

    List<MovieDto> findPageable(PageDto dto);


}
