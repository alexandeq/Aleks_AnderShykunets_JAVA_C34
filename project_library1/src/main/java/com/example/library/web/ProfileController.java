package com.example.library.web;


import com.example.library.dto.PersonDto;
import com.example.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
@RequiredArgsConstructor
public class ProfileController {

    private final PersonService service;

    @PostMapping
    public PersonDto create(@RequestBody PersonDto dto){
        return service.create(dto);




    }
}
