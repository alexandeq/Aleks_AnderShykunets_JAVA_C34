package com.example.project_library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private UUID id;
    private String title;
    private int year;
    private double rating;
    private String description;
    private String posterUrl;

    private List<CommentDto> comments = new ArrayList<>();
}

