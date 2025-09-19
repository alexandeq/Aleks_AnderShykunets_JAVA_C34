package com.example.users.service;

import com.example.users.dto.PersonDto;

public interface PersonService {

    PersonDto create(PersonDto dto);

    PersonDto findByUsername(String username);
}
