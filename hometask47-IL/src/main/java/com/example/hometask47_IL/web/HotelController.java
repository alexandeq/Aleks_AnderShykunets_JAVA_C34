package com.example.hometask47_IL.web;

import com.example.hometask47_IL.dto.ErrorDto;
import com.example.hometask47_IL.dto.HotelDto;
import com.example.hometask47_IL.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService service;

    @PostMapping
    @Operation(summary = "Create hotel", description = "Create hotel", tags = {"create"},
            responses = {
                    @ApiResponse(description = "hotel created", responseCode = "200", content = @Content(schema = @Schema(implementation = HotelDto.class))),
                    @ApiResponse(description = "hotel already registered", responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(description = "unknown error", responseCode = "500", content = @Content())
            })
    public HotelDto createHotel(@RequestBody HotelDto dto){
        return service.createHotel(dto);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all hotels", description = "List of all hotels", tags = {"read"},
            responses = {
                    @ApiResponse(description = "all hotels description", responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelDto.class)))),
                    @ApiResponse(description = "hotel list is disabled", responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(description = "unknown error", responseCode = "500", content = @Content())
            })
    public List<HotelDto> getAllHotels() {
        return service.getAllHotels();
    }
}
