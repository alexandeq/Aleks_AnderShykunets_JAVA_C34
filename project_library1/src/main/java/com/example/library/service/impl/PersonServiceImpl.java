package com.example.library.service.impl;
import com.example.library.client.UserClient;
import com.example.library.dto.PersonDto;
import com.example.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final UserClient client;

    @Override
    public PersonDto create(PersonDto dto) {
        return client.save(dto);
    }

}
