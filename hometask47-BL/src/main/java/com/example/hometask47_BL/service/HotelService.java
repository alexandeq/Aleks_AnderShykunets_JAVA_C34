package com.example.hometask47_BL.service;
import com.example.hometask47_BL.dto.HotelDto;
import com.example.hometask47_BL.entity.HotelEntity;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    HotelDto save(HotelDto dto);

    HotelDto findById(UUID id);

    List<HotelDto> findAll();

    HotelDto updateById(UUID id, HotelDto dto);

}
