package com.example.users.service.impl;

import com.example.users.dto.PersonDto;
import com.example.users.exc.CommonException;
import com.example.users.mapper.PersonMapper;
import com.example.users.repository.PersonRepository;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;
    private final PersonMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public PersonDto create(PersonDto dto) {
        if (repo.existsByUsername(dto.getUsername())) {
            throw new CommonException(808101, "User already exists");
        }

        var entity = mapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        String role = dto.getAuthority();
        if (role == null || role.isBlank()) role = "ROLE_USER";
        else if (!role.startsWith("ROLE_")) role = "ROLE_" + role.toUpperCase();
        entity.setAuthority(role);

        var saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public PersonDto find(String username) {
        var entity = repo.findByUsername(username)
                .orElseThrow(() -> new CommonException(808102, "User not found"));
        return mapper.toDto(entity);
    }
}

