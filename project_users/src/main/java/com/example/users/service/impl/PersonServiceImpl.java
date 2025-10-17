package com.example.users.service.impl;

import com.example.users.domain.PersonEntity;
import com.example.users.dto.PersonDto;
import com.example.users.exc.UserCommonException;
import com.example.users.mapper.PersonMapper;
import com.example.users.repository.PersonRepository;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;
    private final PersonMapper mapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public PersonDto create(PersonDto dto) {
        if (repo.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        var entity = mapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        String role = dto.getAuthority();
        if (role == null || role.isBlank()) {
            role = "ROLE_USER";
        } else if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role.toUpperCase();
        }
        entity.setAuthority(role);

        var saved = repo.save(entity);
        log.info("✅ Зарегистрирован пользователь: {} с ролью {}", saved.getUsername(), saved.getAuthority());
        return mapper.toDto(saved);
    }


    @Override
    public PersonDto find(String username) {
        var entity = repo.findByUsername(username)
                .orElseThrow(() -> new UserCommonException(808102, "User not found"));
        return mapper.toDto(entity);
    }
}