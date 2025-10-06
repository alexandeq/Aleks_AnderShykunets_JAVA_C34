package com.example.users.mapper;

import com.example.users.domain.PersonEntity;
import com.example.users.dto.PersonDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity toEntity(PersonDto dto);

    PersonDto toDto(PersonEntity entity);

   // List<PersonDto> toDtos(List<PersonEntity> entities);
}
