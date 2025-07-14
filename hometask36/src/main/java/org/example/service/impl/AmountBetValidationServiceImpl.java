package org.example.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Wallet;
import org.example.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AmountBetValidationServiceImpl implements ValidationService {

    private final Wallet wallet;

    @Override
    public boolean validate(Bet bet) {
        return wallet.getAmount() != null &&
                wallet.getAmount() > 0 &&
                bet.getAmountBet() != null &&
                bet.getAmountBet() <= wallet.getAmount();
        }

    }
