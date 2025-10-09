package com.example.project_movies.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MovieDto {

    private UUID id;
    private String title;
    private int year;
    private String description;
    private double rating;

    private String posterUrl;

    private List<CommentDto> comments = new ArrayList<>();
}


