package org.example.manytomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class StudentEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CourseEntity> courses = new ArrayList<>();


    public void addCourse(CourseEntity course){
        courses.add(course);
        course.getStudents().add(this);

    }

    public StudentEntity(String name) {
        this.name = name;
    }
}
