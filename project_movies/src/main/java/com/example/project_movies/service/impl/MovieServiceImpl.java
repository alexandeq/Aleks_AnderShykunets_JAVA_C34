package com.example.project_movies.service.impl;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.domain.PosterEntity;
import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.dto.MovieSearchDto;
import com.example.project_movies.dto.PosterDto;
import com.example.project_movies.exc.MovieCommonException;
import com.example.project_movies.mapper.CommentMapper;
import com.example.project_movies.mapper.MovieMapper;

import com.example.project_movies.repository.CommentRepository;
import com.example.project_movies.repository.MovieRepository;
import com.example.project_movies.repository.PosterRepository;
import com.example.project_movies.service.MovieService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;
    private final CommentRepository commentRepo;
    private final MovieMapper movieMapper;
    private final CommentMapper commentMapper;
    private final PosterRepository posterRepo;

    public PosterDto addPoster(UUID movieId, MultipartFile posterFile) throws IOException {
        MovieEntity movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieCommonException(808201, "Movie not found"));

        PosterEntity poster = posterRepo.findByMovieId(movieId).orElseGet(() -> {
            PosterEntity p = new PosterEntity();
            p.setMovie(movie);
            return p;
        });

        try {
            poster.setImage(posterFile.getBytes()); // ✅ byte[]
        } catch (IOException e) {
            throw new MovieCommonException(808208, "Failed to read poster file");
        }

        PosterEntity savedPoster = posterRepo.save(poster);

        return PosterDto.builder()
                .id(savedPoster.getId())
                .posterUrl("/movie/" + movieId + "/poster")
                .build();
    }



    @Override
    public MovieDto getMovieDetails(UUID movieId) {
        MovieEntity entity = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieCommonException(808202, "Movie not found"));

        MovieDto dto = movieMapper.toDto(entity);

        PosterEntity poster = posterRepo.findByMovieId(movieId).orElse(null);
        if (poster != null && poster.getImage() != null) {

            dto.setPosterUrl("/movie/" + movieId + "/poster");
        }

        List<CommentDto> comments = commentMapper.toDtos(commentRepo.findByMovieId(movieId));
        dto.setComments(comments);

        return dto;
    }

    @Override
    public MovieDto save(MovieDto dto) {
        var entity = movieMapper.toEntity(dto);
        var result = movieRepo.save(entity);
        return movieMapper.toDto(result);
    }

    @Override
    public List<MovieDto> findAll() {
        return movieMapper.toDtos(movieRepo.findAll());
    }


    @Override
    public MovieDto findById(UUID id) {
        MovieEntity entity = movieRepo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808202, "Movie not found"));

        MovieDto dto = movieMapper.toDto(entity);

        PosterEntity poster = posterRepo.findByMovieId(id).orElse(null);
        if (poster != null) {
            dto.setPosterUrl("/movie/" + id + "/poster");
        }

        return dto;
    }



    @Override
    public byte[] getPoster(UUID movieId) {
        return posterRepo.findByMovieId(movieId)
                .map(PosterEntity::getImage)
                .orElse(null);
    }



//    @Override
//    public MovieDto findById(UUID id) {
//        var entity = movieRepo.findById(id)
//                .orElseThrow(() -> new MovieCommonException(808202, "Movie with this ID not found"));
//
//        return movieMapper.toDto(entity);
//    }


    @Override
    public MovieDto editByIdByAdmin(UUID id, MovieDto dto) {
        var existingEntity = movieRepo.findById(id).get();

        existingEntity.setTitle(dto.getTitle());
        existingEntity.setRating(dto.getRating());
        existingEntity.setYear(dto.getYear());

        var result = movieRepo.save(existingEntity);
        return movieMapper.toDto(result);
    }

    @Override
    @Transactional
    public CommentDto addComment(UUID movieId, CommentDto dto) {
        var movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new MovieCommonException(808201, "Movie not found"));

        var entity = commentMapper.toEntity(dto);
        entity.setId(null); // ✅ новая сущность
        entity.setMovie(movie);

        var saved = commentRepo.saveAndFlush(entity); // ✅ сразу записываем в БД

        // 🔹 обновляем рейтинг фильма
        Double avg = commentRepo.getAverageRatingByMovieId(movieId);
        if (avg != null) {
            BigDecimal bd = new BigDecimal(avg).setScale(1, RoundingMode.HALF_UP);
            movie.setRating(bd.doubleValue());
        } else {
            movie.setRating(0.0);
        }

        movieRepo.save(movie); // ✅ теперь Hibernate не трогает комментарии

        return commentMapper.toDto(saved);
    }


//    @Override
//    public List<CommentDto> findByMovieId(UUID movieId) {
//        return commentMapper.toDtos(commentRepo.findByMovieId(movieId));
//    }

    @Override
    public List<CommentDto> getComments(UUID movieId) {
        return commentMapper.toDtos(commentRepo.findByMovieId(movieId));
    }


    @Override
    public void delete(UUID id) {
        var entity = movieRepo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808202, " delete failed: movie with this ID not found"));

        movieRepo.delete(entity);

        movieMapper.toDto(entity);
    }

    @Override
    public List<MovieDto> search(MovieSearchDto dto) {

        var specification = createSpecification(dto);
        var all = movieRepo.findAll(specification);
        return movieMapper.toDtos(all);

    }


    public static Specification<MovieEntity> createSpecification (MovieSearchDto dto){
        return (root, query, builder) -> {

            List<Predicate> predicates = new ArrayList<>();


            if (StringUtils.isNotBlank(dto.getTitle())) {
                predicates.add(builder.like(root.get("title"), "%" + dto.getTitle().toLowerCase() + "%"));
            }


            if (dto.getFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("year"), dto.getFrom()));
            }


            if (dto.getTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("year"), dto.getTo()));
            }


            if (dto.getRating() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("rating"), dto.getRating()));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}




