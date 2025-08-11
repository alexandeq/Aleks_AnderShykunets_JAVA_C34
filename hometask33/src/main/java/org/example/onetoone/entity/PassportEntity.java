package org.example.onetoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class PassportEntity {

    @Id
    @UuidGenerator
    private UUID id;
    private String series;
    private Integer number;


    public PassportEntity(String series, Integer number) {
        this.series = series;
        this.number = number;
    }
}
