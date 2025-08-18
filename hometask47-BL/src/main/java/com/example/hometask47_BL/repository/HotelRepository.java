package com.example.hometask47_BL.repository;

import com.example.hometask47_BL.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

    boolean existsByName(String name);

    boolean existsById(UUID id);

}
