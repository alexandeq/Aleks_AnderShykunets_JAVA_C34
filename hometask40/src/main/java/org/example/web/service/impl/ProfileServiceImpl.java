package org.example.web.service.impl;

import org.example.web.dto.PersonDto;
import org.example.web.exc.AgeValidationException;
import org.example.web.exc.EmailValidationException;
import org.example.web.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Override
    public void process(PersonDto personDto) {

        if (personDto.getAge() < 18) {
            throw new AgeValidationException(personDto);
        }

        if (!personDto.getEmail().contains("@")) {
            throw new EmailValidationException();
        }
    }
}


