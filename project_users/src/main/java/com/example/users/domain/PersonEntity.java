package com.example.users.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "persons")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PersonEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String login;
    private String password;

}
