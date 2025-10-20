package com.example.project_library.service.impl;

import com.example.project_library.client.PersonClient;
import com.example.project_library.dto.PersonDto;
import com.example.project_library.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService implements UserDetailsService {

    private final PersonService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonDto user = service.find(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getAuthority()))
        );
    }

}


