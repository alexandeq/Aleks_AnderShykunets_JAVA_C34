package org.example.manytomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class CourseEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<StudentEntity> students = new ArrayList<>();

    public CourseEntity(String name) {
        this.name = name;
    }
}
