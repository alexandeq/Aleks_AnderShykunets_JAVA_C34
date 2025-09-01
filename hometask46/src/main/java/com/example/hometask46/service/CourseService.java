package com.example.hometask46.service;
import com.example.hometask46.dto.CourseDto;
import com.example.hometask46.exception.CourseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final Map<UUID, CourseDto> courseMap = new HashMap<>();

    public CourseDto saveCourse(CourseDto courseDto) {
        UUID id = UUID.randomUUID();
        courseDto.setId(id);
        courseMap.put(id, courseDto);
        return courseDto;
    }

    public CourseDto getCourseById(UUID id) {
        return courseMap.values()
                .stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(CourseNotFoundException::new); //если мы ввели id, которого нету в мапе- выбрасываем ошибку
    }

    public List<CourseDto> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public void delete(UUID id) {
        if (courseMap.containsKey(id)) {
            courseMap.remove(id);
        } else {
            throw new CourseNotFoundException(); //если мы хотим удалить по id, которого нету в мапе- выбрасываем ошибку
        }
    }

    public CourseDto update(UUID id, CourseDto courseDto) {
        var exist = courseMap.values()
                .stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .get();

        exist.setName(courseDto.getName());
        exist.setDuration(courseDto.getDuration());
        exist.setPrice(courseDto.getPrice());
        exist.setActive(courseDto.isActive());

        return exist;
    }

}


