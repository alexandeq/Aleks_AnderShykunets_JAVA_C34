package com.example.hometask47_IL.service.impl;

import com.example.hometask47_IL.client.OrderClient;
import com.example.hometask47_IL.dto.HotelDto;
import com.example.hometask47_IL.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final OrderClient client;

    @Override
    public HotelDto createHotel(HotelDto dto) {
        return client.save(dto);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return client.findAll();
    }
}