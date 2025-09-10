package com.example.users.repository;

import com.example.users.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
    PersonEntity findByLogin(String login);

    boolean existsByLogin(String login);
}
