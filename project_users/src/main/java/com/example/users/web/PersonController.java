package com.example.users.web;

import com.example.users.dto.PersonDto;
import com.example.users.service.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl service;


    @PostMapping("/register")
    public PersonDto register(@RequestBody PersonDto dto) {
        return service.create(dto);
    }

    @GetMapping("/user")
    public PersonDto find(@RequestParam("username") String username) {
        return service.find(username);
    }


}

