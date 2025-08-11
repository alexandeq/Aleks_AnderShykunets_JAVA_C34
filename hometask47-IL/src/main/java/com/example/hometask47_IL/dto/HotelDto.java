package com.example.hometask47_IL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class HotelDto {

    private UUID id;
    private String name;
    private Integer stars;

}
