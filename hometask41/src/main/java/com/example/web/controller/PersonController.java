package com.example.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Value("${app.age.min}")
    private Integer minAge;
    @Value("${app.age.max}")
    private Integer maxAge;
    @Value("${app.name}")
    private String name;
    @Value("${app.lastname}")
    private String lastname;

    @GetMapping

    public String personInfo() {


    public String personInfo(){

        System.out.println("Min age: " + minAge);
        System.out.println("Max age: " + maxAge);
        System.out.println("Name: " + name);
        System.out.println("Lastname: " + lastname);

        return "index";


    }
}


