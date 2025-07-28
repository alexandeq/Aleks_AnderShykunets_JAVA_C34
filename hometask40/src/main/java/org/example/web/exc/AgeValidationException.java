package org.example.web.exc;

import lombok.Getter;
import org.example.web.dto.PersonDto;

@Getter
public class AgeValidationException extends RuntimeException {

    private final PersonDto personDto;

    public AgeValidationException(PersonDto personDto) {
        this.personDto = personDto;
    }
}
