package com.example.web.service.impl;

import com.example.web.domain.MovieDto;
import com.example.web.domain.MovieSearchDto;
import com.example.web.mapper.MovieMapper;
import com.example.web.repository.MovieRepository;
import com.example.web.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repo;
    private final MovieMapper mapper;

    @Override
    public void save(MovieDto dto) {

        var entity = mapper.toEntity(dto);

        repo.save(entity);
    }

    @Override
    public List<MovieDto> findAll() {

        var all = repo.findAll();

        return mapper.toDto(all);
    }

    @Override
    public List<MovieDto> findByTitle(MovieSearchDto dto) {

        var result = repo.findByTitle(dto.getTitle());

        return mapper.toDto(result);
    }
}
