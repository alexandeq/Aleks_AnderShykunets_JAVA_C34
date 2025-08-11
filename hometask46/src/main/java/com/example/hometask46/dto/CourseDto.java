package com.example.hometask46.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class CourseDto {

    private UUID id;
    private String name;
    private Integer duration;
    private Integer price;
    private boolean isActive;

    public CourseDto(String name, Integer duration, Integer price, boolean isActive) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.isActive = isActive;
    }
}
