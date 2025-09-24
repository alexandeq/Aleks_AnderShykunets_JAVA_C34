//package com.example.project_library.web;
//
//import com.example.project_library.dto.PersonDto;
//import com.example.project_library.service.PersonService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequiredArgsConstructor
//public class RestController {
//
//    private final PersonService service;
//
//    @GetMapping
//    public PersonDto find(@RequestParam("username") String username) {
//        return service.findByUsername(username);
//    }
//
//    @PostMapping
//    public PersonDto save(@RequestBody PersonDto dto) {
//        return service.create(dto);
//
//    }
//    }

