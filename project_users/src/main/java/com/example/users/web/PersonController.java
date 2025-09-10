package com.example.users.web;

import com.example.users.dto.PersonDto;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
public class PersonController {

    private final PersonService service;

    @PostMapping
    public PersonDto save(@RequestBody PersonDto dto){
        return service.save(dto);

    }

    @GetMapping
    public PersonDto findByLogin(@RequestParam("login") String login){
        return service.findByLogin(login);
    }


}
