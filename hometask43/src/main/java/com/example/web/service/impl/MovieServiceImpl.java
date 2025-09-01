package com.example.web.service.impl;

import com.example.web.domain.MovieDto;
import com.example.web.domain.MovieSearchDto;
import com.example.web.domain.PageDto;
import com.example.web.entity.MovieEntity;
import com.example.web.mapper.MovieMapper;
import com.example.web.repository.MovieRepository;
import com.example.web.service.MovieService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MovieDto> searchByTitleOrRating(MovieSearchDto dto) {

        var specification = createSpecification(dto);

        var result = repo.findAll(specification);

        return mapper.toDto(result);
    }

    @Override
    public List<MovieDto> findPageable(PageDto dto) {
        var page = PageRequest.of(dto.getPage(), dto.getSize());

        var result = repo.findAll(page);

        return mapper.toDto(result.getContent());
    }

    private Specification<MovieEntity> createSpecification(MovieSearchDto dto) {
        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNoneBlank(dto.getTitle())) {
                predicates.add(builder.like(root.get("title"), "%" + dto.getTitle() + "%")); //поиск по полному названию и частичному
            }

            if(dto.getFrom() != null){
                predicates.add(builder.greaterThanOrEqualTo(root.get("rating"), dto.getFrom())); // поиск по рейтингу
            }
            if(dto.getTo() != null){
                predicates.add((builder.lessThanOrEqualTo(root.get("rating"), dto.getTo())));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}