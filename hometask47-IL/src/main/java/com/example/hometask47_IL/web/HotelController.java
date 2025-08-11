package com.example.hometask47_IL.web;

import com.example.hometask47_IL.dto.HotelDto;
import com.example.hometask47_IL.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService service;

    @PostMapping
    public HotelDto createHotel(@RequestBody HotelDto dto){
        return service.createHotel(dto);
    }

    @GetMapping("/all")
    public List<HotelDto> getAllHotels() {
        return service.getAllHotels();
    }
}
