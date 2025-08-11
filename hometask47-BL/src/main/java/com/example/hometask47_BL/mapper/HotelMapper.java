package com.example.hometask47_BL.mapper;
import com.example.hometask47_BL.entity.HotelEntity;
import com.example.hometask47_BL.dto.HotelDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelEntity toEntity(HotelDto dto);

    HotelDto toDto(HotelEntity entity);

    List<HotelDto> toDtos(List<HotelEntity> entities);



}
