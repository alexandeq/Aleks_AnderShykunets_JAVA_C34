package com.example.project_library.service.impl;

import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonClient client;

    public PersonDto register(PersonDto dto) {
        return client.register(dto);
    }

    public PersonDto find(String username) {
        try {
            return client.find(username);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Пользователь не найден: " + username);
        }
    }


}






