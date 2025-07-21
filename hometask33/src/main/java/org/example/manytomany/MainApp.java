package org.example.manytomany;

import org.example.manytomany.entity.CourseEntity;
import org.example.manytomany.entity.StudentEntity;
import org.example.manytomany.service.StudentService;

import java.util.UUID;

public class MainApp {

    private static final StudentService service = new StudentService();

    public static void main(String[] args) {

        StudentEntity student1 = new StudentEntity("Pavel");
        StudentEntity student2 = new StudentEntity("Daria");
        CourseEntity course = new CourseEntity("math");

        student1.addCourse(course);
        student2.addCourse(course);

        var savedStudent1 = service.save(student1);
        var savedStudent2 = service.save(student1);

        var student = service.findById(UUID.fromString("f0061829-67c4-4fae-b64c-eff7c1deb144"));

    }
}
