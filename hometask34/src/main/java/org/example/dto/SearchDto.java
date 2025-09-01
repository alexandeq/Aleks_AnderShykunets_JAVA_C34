package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.Brand;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchDto {

    private Brand brand;

    private Integer minPrice;
    private Integer maxPrice;

    private Integer minMileage;
    private Integer maxMileage;

    private Integer minYear;

}