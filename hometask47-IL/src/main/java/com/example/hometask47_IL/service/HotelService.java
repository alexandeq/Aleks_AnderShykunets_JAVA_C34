package com.example.hometask47_IL.service;
import com.example.hometask47_IL.dto.HotelDto;
import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto dto);

    List<HotelDto> getAllHotels();



}
