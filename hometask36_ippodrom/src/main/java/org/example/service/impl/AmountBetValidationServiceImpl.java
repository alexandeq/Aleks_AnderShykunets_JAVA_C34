package org.example.service.impl;

import org.example.domain.Wallet;
import org.example.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class AmountBetValidationServiceImpl implements ValidationService {

    @Override
    public boolean validate(Wallet wallet) {
        return wallet.getAmount() != null &&
                wallet.getAmount() > 0 &&
                wallet.getAmountBet() != null &&
                wallet.getAmountBet() <= wallet.getAmount();
        }
    }