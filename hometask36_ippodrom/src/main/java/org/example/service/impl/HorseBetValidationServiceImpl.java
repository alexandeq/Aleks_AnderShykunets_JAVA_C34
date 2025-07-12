package org.example.service.impl;

import org.example.domain.Horse;
import org.example.domain.Wallet;
import org.example.service.ValidationService;

import java.util.List;

public class HorseBetValidationServiceImpl implements ValidationService {

    List<Integer> horseList = Horse.getHorses();

    @Override
    public boolean validate(Wallet wallet) {
            return wallet.getHorseBet() != null &&
                    wallet.getHorseBet() > 0 &&
                    horseList.contains(wallet.getHorseBet());
            }

    }
