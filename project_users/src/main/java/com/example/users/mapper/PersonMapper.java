package com.example.users.mapper;

import com.example.users.domain.PersonEntity;
import com.example.users.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(PersonEntity entity);

    PersonEntity toEntity(PersonDto dto);
}
