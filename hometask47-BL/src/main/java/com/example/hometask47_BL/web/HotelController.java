package com.example.hometask47_BL.web;

import com.example.hometask47_BL.dto.HotelDto;
import com.example.hometask47_BL.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService service;

    @PostMapping
    public HotelDto save(@RequestBody HotelDto dto){
         return service.save(dto);
    }

    @GetMapping
    public HotelDto findById(@RequestParam(name = "id") UUID id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<HotelDto> findAll() {
        return service.findAllById();
    }

    @PutMapping
    public HotelDto update(@RequestParam UUID id, @RequestBody HotelDto dto) {
        return service.updateById(id, dto);
    }


}
