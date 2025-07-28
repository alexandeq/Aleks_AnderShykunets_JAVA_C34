package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.web.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop")
public class HomeController {

    @PostMapping("/orders")
    public String homePagePost(PersonDto personDto){
        return "index";
    }

    @GetMapping("/orders")
    public String homePageGet(){
        return "index";
    }

}
