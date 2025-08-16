package com.example.hometask47_BL.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotelCommonException extends RuntimeException {

    private Integer errorCode;
    private  String details;

}
