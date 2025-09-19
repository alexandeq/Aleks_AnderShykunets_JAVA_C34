package com.example.project_library.repository;

import com.example.project_library.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    Optional<PersonEntity> findByUsername(String username);

}
