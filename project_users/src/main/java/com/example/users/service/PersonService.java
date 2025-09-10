package com.example.users.service;

import com.example.users.dto.PersonDto;

public interface PersonService {

    PersonDto save(PersonDto dto);

    PersonDto findByLogin(String login);
}
