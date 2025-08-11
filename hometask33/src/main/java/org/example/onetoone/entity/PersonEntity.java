package org.example.onetoone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "persons")

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class PersonEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;


    public PersonEntity(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}

