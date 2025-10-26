package com.example.project_library.service.impl;

import com.example.project_library.client.MovieAdminClient;
import com.example.project_library.client.MovieUserClient;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.PosterDto;
import com.example.project_library.service.MovieAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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



}
