package com.example.users.exc;

import lombok.Getter;


@Getter
public class CommonException extends RuntimeException {

    private final Integer code;

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

