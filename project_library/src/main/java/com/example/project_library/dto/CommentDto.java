package com.example.project_library.dto;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private UUID id;

    private String comment;
    private double rating;
    private UUID movieId;

}


