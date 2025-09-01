package com.example.hometask47_BL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    private UUID id;
    private String name;
    private Integer stars;

}
