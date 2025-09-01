package com.example.hometask47_BL.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "hotels")
@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private Integer stars;

}
