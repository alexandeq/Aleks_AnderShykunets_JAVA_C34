package com.example.hometask47_IL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class ErrorDto {

    private Integer errorCode;
    private String details;

}
