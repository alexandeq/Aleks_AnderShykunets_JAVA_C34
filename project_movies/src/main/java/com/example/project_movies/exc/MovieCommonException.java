package com.example.project_movies.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovieCommonException extends RuntimeException{

    private Integer code;
    private String message;
}
