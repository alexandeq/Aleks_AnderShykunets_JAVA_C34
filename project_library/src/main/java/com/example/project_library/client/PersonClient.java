package com.example.project_library.client;
import com.example.project_library.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "person-client", url = "http://localhost:8081")
public interface PersonClient {

    @PostMapping("/register")
    PersonDto register(@RequestBody PersonDto dto);

    @GetMapping//("/users/{username}")
    PersonDto find(@RequestParam("username") String username);
}
