package com.example.hometask47_BL.service.impl;
import com.example.hometask47_BL.dto.HotelDto;
import com.example.hometask47_BL.exc.HotelCommonException;
import com.example.hometask47_BL.mapper.HotelMapper;
import com.example.hometask47_BL.repository.HotelRepository;
import com.example.hometask47_BL.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    @Value("${app.hotel.enabled: true }")
    private boolean enabled;

    private final HotelRepository repo;
    private final HotelMapper mapper;

    @Override
    public HotelDto save(HotelDto dto) {
        var entity = mapper.toEntity(dto);

        if(repo.existsByName(entity.getName())){
            throw new HotelCommonException(808101, "hotel with name: " + entity.getName() + " - already exist");
        }

        var result =  repo.save(entity);

        return mapper.toDto(result);
    }

    public HotelDto findById(UUID id) {

        if (!repo.existsById(id)) {
            throw new HotelCommonException(808102, "Hotel with this ID not found");
        }

        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<HotelDto> findAll() {

        if(!enabled) {
            throw new HotelCommonException(808103, "Hotel list is disabled");
        }

        return mapper.toDtos(repo.findAll());
    }

    @Override
    public HotelDto updateById(UUID id, HotelDto dto) {
        var existingEntity = repo.findById(id).get();

        existingEntity.setName(dto.getName());
        existingEntity.setStars(dto.getStars());

        var result = repo.save(existingEntity);
        return mapper.toDto(result);
    }
}
