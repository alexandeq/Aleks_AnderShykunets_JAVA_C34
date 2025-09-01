package com.example.hometask47_IL.client;
import com.example.hometask47_IL.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-client", url = "http://localhost:8081", path = "/hotel")
public interface OrderClient {

    @PostMapping
    HotelDto save(@RequestBody HotelDto dto);

    @GetMapping("/all")
    List<HotelDto> findAll();

}
