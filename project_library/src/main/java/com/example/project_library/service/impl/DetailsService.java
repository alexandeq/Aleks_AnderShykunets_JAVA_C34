package com.example.project_library.service.impl;

import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DetailsService implements UserDetailsService {

    private final PersonClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonDto user = client.find(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        log.info("🔐 Загружен пользователь {} с ролью {}", user.getUsername(), user.getAuthority());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthority())
                .build();
    }
}


