package com.example.hometask46.web;
import com.example.hometask46.dto.CourseDto;
import com.example.hometask46.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;

    @GetMapping
    public CourseDto getByID(@RequestParam(name= "id") UUID id){
        return service.getCourseById(id);
    }

    @GetMapping("/all")
    public List<CourseDto> getAllCourses() {
        return service.getAllCourses();
    }

    @PostMapping
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
        return service.saveCourse(courseDto);
    }

    @DeleteMapping
    public void delete(@RequestParam(name = "id") UUID id) {
        service.delete(id);
    }

    @PutMapping
    public CourseDto update(@RequestParam(name="id") UUID id, @RequestBody CourseDto courseDto){
        return service.update(id,courseDto);
    }

}



