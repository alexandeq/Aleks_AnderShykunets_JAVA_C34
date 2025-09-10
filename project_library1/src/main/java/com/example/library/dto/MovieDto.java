package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private UUID id;
    private String name;
    private Integer rating;
    private String comment;
    private Integer year;
}
