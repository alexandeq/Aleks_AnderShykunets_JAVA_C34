package com.example.users.web;

import com.example.users.dto.PersonDto;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping("/register")
    public PersonDto register(@RequestBody PersonDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public PersonDto find(@RequestParam String username) {
        return service.find(username);
    }
}
