package com.example.hometask47_BL.service.impl;
import com.example.hometask47_BL.dto.HotelDto;
import com.example.hometask47_BL.mapper.HotelMapper;
import com.example.hometask47_BL.repository.HotelRepository;
import com.example.hometask47_BL.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repo;
    private final HotelMapper mapper;

    @Override
    public HotelDto save(HotelDto dto) {    // сохраняем отель
        var entity = mapper.toEntity(dto);
        var result =  repo.save(entity);
        return mapper.toDto(result);
    }

    public HotelDto findById(UUID id) {                 // поиск отеля по id
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<HotelDto> findAllById() {   // список всех отелей
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public HotelDto updateById(UUID id, HotelDto dto) {   // изменение информации об отелях
        var existingEntity = repo.findById(id).get();

        existingEntity.setName(dto.getName());
        existingEntity.setStars(dto.getStars());

        var result = repo.save(existingEntity);
        return mapper.toDto(result);
    }
}

// через postman все проверил связь IL-BL все методы работают