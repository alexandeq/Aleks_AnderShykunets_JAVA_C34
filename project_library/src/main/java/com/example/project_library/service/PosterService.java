package com.example.project_library.service;

import com.example.project_library.dto.PosterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface PosterService {

    ResponseEntity<byte[]> getPoster(UUID id);

    PosterDto addPoster(UUID movieId, MultipartFile posterFile) throws IOException;

    byte[] getPosterByAdmin(UUID movieId);

}

