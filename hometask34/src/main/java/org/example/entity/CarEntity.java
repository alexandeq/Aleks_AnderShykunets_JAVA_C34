package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class CarEntity {

    @Id
    @UuidGenerator
    private String id;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    private Integer price;

    private Integer mileage;

    private Integer year;

    public CarEntity(Brand brand, Integer price, Integer mileage, Integer productionYear) {
        this.brand = brand;
        this.price = price;
        this.mileage = mileage;
        this.year = productionYear;
    }
}

