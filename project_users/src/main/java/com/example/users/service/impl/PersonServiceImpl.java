package com.example.users.service.impl;

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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService, UserDetailsService {

    private final PersonRepository repo;
    private final PersonMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("🔐 Попытка входа с логином: {}", username);

        return repo.findByUsername(username)
                .orElseThrow(() -> {
                    log.warn("❌ Пользователь не найден: {}", username);
                    return new UsernameNotFoundException("User not found: " + username);
                });
    }

    @Override
    public PersonDto create(PersonDto dto) {
        if (repo.existsByUsername(dto.getUsername())) {
            throw new UserCommonException(808101, "User already exists");
        }

        var entity = mapper.toEntity(dto);

        var saved = repo.save(entity);
        log.info("✅ Зарегистрирован новый пользователь: {}", entity.getUsername());
        return mapper.toDto(saved);
    }

    @Override
    public PersonDto find(String username) {
        return null;
    }
}

//    @Override
//    public PersonDto create(PersonDto dto) {
//
//        if (repo.existsByUsername(dto.getUsername())) {
//            throw new UserCommonException(808101, "User already exists");
//        }
//        var entity = mapper.toEntity(dto);
//
//        var saved = repo.save(entity);
//        return mapper.toDto(saved);
//    }
//
//    @Override
//    public PersonDto find(String username) {
//        var entity = repo.findByUsername(username)
//                .orElseThrow(() -> new UserCommonException(808102, "User not found with username: " + username));
//        return mapper.toDto(entity);
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return repo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//    }
//
//}
//
//
//
//
//
//
//
