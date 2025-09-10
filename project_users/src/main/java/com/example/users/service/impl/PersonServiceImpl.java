package com.example.users.service.impl;

import com.example.users.dto.PersonDto;
import com.example.users.exc.UserCommonException;
import com.example.users.mapper.PersonMapper;
import com.example.users.repository.PersonRepository;
import com.example.users.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repo;
    private final PersonMapper mapper;


    @Override
    public PersonDto save(PersonDto dto) {
        var entity = mapper.toEntity(dto);

        if(repo.existsByLogin(entity.getLogin())){
            throw  new UserCommonException(808101, "user with login: " + entity.getLogin() + " - already exist");

        }
        var result = repo.save(entity);

        return mapper.toDto(result);
    }

    @Override
    public PersonDto findByLogin(String login) {

        if(!repo.existsByLogin(login)){
            throw new UserCommonException(808102, "user with login: " + login + " - not found");
        }
        return mapper.toDto(repo.findByLogin(login));
    }
}
