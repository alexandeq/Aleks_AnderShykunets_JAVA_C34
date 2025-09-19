package com.example.users.web;

import com.example.users.dto.PersonDto;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PersonController {

    private final PersonService service;

    @PostMapping
    public PersonDto save(@RequestBody PersonDto dto){
        return service.create(dto);

    }

    @GetMapping
    public PersonDto findByUsername(@RequestParam("username") String username){
        return service.findByUsername(username);
    }


}
