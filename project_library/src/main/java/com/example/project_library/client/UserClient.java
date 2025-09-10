package com.example.project_library.client;
import com.example.project_library.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-client", url = "http://localhost:8081", path = "/film")
public interface UserClient {

    @PostMapping
    PersonDto save(@RequestBody PersonDto dto);

    @GetMapping
    PersonDto find(@RequestParam("login") String login);


}
