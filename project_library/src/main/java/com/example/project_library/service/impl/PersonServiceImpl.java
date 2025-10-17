package com.example.project_library.service.impl;

import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonClient client;

    public PersonDto register(PersonDto dto) {
        return client.register(dto);
    }

//    public PersonDto findByUsername(String username) {
//        return client.find(username);
//    }


}


