package com.example.hometask47_IL.exc;

import com.example.hometask47_IL.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonException extends RuntimeException {

    private ErrorDto detailDto;

}