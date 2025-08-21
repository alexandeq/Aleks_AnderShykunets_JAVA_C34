package com.example.hometask50.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/support")
    public String support(){
        return "support.html";
    }

    @GetMapping("/user")
    public String user(){
        return "user.html";
    }

    @GetMapping("/removed")
    public String deny() {
        return "removed.html";
    }

    @GetMapping("/auth")
    public String all() {
        return "auth.html";
    }
}
