package com.example.project_library.web;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    public PersonDto create(@RequestBody PersonDto dto){
        return service.create(dto);
    }

    @GetMapping
    public PersonDto findByLogin(@RequestParam("login") String login){
        return service.findByLogin(login);
    }

}
