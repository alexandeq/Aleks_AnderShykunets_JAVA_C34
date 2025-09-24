package com.example.project_movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private UUID id;

    private UUID movieID;
    private String comment;
    private Integer rating;



}