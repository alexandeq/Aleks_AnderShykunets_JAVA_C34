package com.example.project_library.exc;

import com.example.project_library.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class CommonException extends RuntimeException {

    private final Integer errorCode;

    public CommonException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}