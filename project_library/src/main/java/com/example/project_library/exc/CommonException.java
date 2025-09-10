package com.example.project_library.exc;

import com.example.project_library.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonException extends RuntimeException {

    private ErrorDto errorDto;

    }

