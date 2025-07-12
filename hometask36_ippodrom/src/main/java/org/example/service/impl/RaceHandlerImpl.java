package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Wallet;
import org.example.service.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RaceHandlerImpl implements RaceHandler {

    private final ValidationService amountValidator = new AmountBetValidationServiceImpl();
    private final ValidationService horseValidator = new HorseBetValidationServiceImpl();
    private final BetService betService;
    private final NotificationService notificationService;
    private final WalletService walletService;


    @Override
    public void startRace(Wallet wallet) {

        var isAmountBetValid = amountValidator.validate(wallet);
        var isHorseBetValid = horseValidator.validate(wallet);

        if(!isAmountBetValid){
            notificationService.sendError(wallet.getAmountBet());
            return;
        }

        if(!isHorseBetValid){
            notificationService.sendHorseBetError(wallet.getHorseBet());
            return;
        }

        notificationService.sendNotify(wallet.getAmountBet());

        betService.winLose(wallet);

        notificationService.endBalance(wallet);

        walletService.updateAmount(wallet.getAmount());

    }
}
