package com.example.users.service.impl;

import com.example.users.dto.PersonDto;
import com.example.users.exc.UserCommonException;
import com.example.users.mapper.PersonMapper;
import com.example.users.repository.PersonRepository;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService, UserDetailsService {

    private final PersonRepository repo;
    private final PersonMapper mapper;

    @Override
    public PersonDto create(PersonDto dto) {

        if (repo.existsByUsername(dto.getUsername())) {
            throw new UserCommonException(808101, "User already exists");
        }
        var entity = mapper.toEntity(dto);

        var saved = repo.save(entity);
        return mapper.toDto(saved);

    }


    @Override
    public PersonDto findByUsername(String username) {
        var entity = repo.findByUsername(username)
                .orElseThrow(() -> new UserCommonException(808102, "User not found with username: " + username));
        return mapper.toDto(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}







