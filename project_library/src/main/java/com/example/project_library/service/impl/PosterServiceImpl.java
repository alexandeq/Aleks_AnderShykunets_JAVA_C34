package com.example.project_library.service.impl;

import com.example.project_library.client.MovieAdminClient;
import com.example.project_library.client.MovieUserClient;
import com.example.project_library.dto.PosterDto;
import com.example.project_library.service.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
@Service
@RequiredArgsConstructor

public class PosterServiceImpl implements PosterService {

    private final MovieUserClient userClient;
    private final MovieAdminClient adminClient;


    @Override
    public ResponseEntity<byte[]> getPoster(UUID id) {
        return userClient.getPoster(id);
    }

    @Override
    public PosterDto addPoster(UUID movieId, MultipartFile posterFile) throws IOException {
        return adminClient.addPoster(movieId, posterFile).getBody();
    }

    @Override
    public byte[] getPosterByAdmin(UUID movieId) {
        ResponseEntity<byte[]> response = adminClient.getPosterByAdmin(movieId);
        return response.getBody();
    }
}
