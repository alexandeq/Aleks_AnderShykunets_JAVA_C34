package com.example.hometask47_IL.service.impl;

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

    private final RestTemplate restTemplate;

    @Override
    public HotelDto createHotel(HotelDto dto) {
        return restTemplate.postForObject("http://localhost:8081/hotel", dto, HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        var result = restTemplate.getForObject("http://localhost:8081/hotel/all", HotelDto[].class);
        return Arrays.stream(result).collect(Collectors.toList());
    }
}