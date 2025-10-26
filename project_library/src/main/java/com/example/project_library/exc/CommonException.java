package com.example.project_library.exc;

import lombok.Getter;


@Getter
public class CommonException extends RuntimeException {

    private final Integer errorCode;

    public CommonException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}