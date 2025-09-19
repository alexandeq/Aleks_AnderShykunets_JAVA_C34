package com.example.project_library.service.impl;

import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.ErrorDto;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.exc.CommonException;
import com.example.project_library.repository.PersonRepository;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService, UserDetailsService {

    private final PersonClient client;
    private final PersonRepository repo;

    @Override
    public PersonDto create(PersonDto dto) {
        return client.save(dto);
    }

    @Override
    public PersonDto findByUsername(String username) {
        return client.find(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .orElseThrow();
    }
}


