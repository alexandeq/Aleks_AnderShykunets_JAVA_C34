package com.example.project_library.service.impl;

import com.example.project_library.client.UserClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final UserClient client;

    @Override
    public PersonDto create(PersonDto dto) {
        return client.save(dto);
    }

    @Override
    public PersonDto findByLogin(String login) {
        return client.find(login);
    }
}
