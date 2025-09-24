package com.example.project_movies.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MovieDto {

    private UUID id;
    private String name;
    private int year;
    private double rating;
    private String description;
    private List<CommentDto> comments;

    //картинка

}