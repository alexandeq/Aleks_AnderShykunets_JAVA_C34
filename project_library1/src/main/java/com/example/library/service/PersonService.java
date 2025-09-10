package com.example.library.service;

import com.example.library.dto.PersonDto;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    PersonDto create(PersonDto dto);



}
