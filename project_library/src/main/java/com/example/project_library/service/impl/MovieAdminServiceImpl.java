package com.example.project_library.service.impl;

import com.example.project_library.client.MovieAdminClient;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PageDto;
import com.example.project_library.service.MovieAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MovieAdminServiceImpl implements MovieAdminService {

    private final MovieAdminClient client;

    @Override
    public MovieDto create(MovieDto dto) {
        return client.create(dto);
    }

    @Override
    public MovieDto update(UUID id, MovieDto dto) {
        return client.edit(id, dto);
    }

    @Override
    public void delete(UUID id) {
        client.delete(id);
    }

    @Override
    public MovieDto findById(UUID id) {
        return client.findById(id);
    }

    @Override
    public List<MovieDto> findPageable(PageDto dto) {
        return client.findPage(dto);

    }
}
