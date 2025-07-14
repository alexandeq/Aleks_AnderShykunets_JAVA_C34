package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Horse;
import org.example.domain.Wallet;
import org.example.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorseBetValidationServiceImpl implements ValidationService {

    private final List<Horse> horsesList;

    @Override
    public boolean validate(Bet bet) {
            return bet.getHorseBet() != null &&
                    bet.getHorseBet() > 0 &&
                    horsesList.stream()
                            .anyMatch(h -> h.getName().equals(String.valueOf(bet.getHorseBet())));}

    }