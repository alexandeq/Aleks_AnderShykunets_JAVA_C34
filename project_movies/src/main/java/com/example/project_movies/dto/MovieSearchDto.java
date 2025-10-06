package com.example.project_movies.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSearchDto {

    private String title;

    private Integer from;
    private Integer to;

    private Integer rating;
}

