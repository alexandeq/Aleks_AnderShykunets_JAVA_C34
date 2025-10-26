package com.example.project_library.service;

import com.example.project_library.dto.PersonDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface PersonService  {

    PersonDto register(PersonDto dto);

    PersonDto find(String username);
}
