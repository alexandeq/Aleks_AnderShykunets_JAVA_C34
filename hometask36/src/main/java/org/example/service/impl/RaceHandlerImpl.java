package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Wallet;
import org.example.service.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RaceHandlerImpl implements RaceHandler {

    private final AmountBetValidationServiceImpl amountValidator;
    private final HorseBetValidationServiceImpl horseValidator;
    private final BetService betService;
    private final NotificationService notificationService;
    private final WalletService walletService;
    private final StartService startService;
    private final EndService endService;
    private final Wallet wallet;


    @Override
    public void startRace(Bet bet) {

        while (true) {

            startService.start(bet);

            var isAmountBetValid = amountValidator.validate(bet);
            var isHorseBetValid = horseValidator.validate(bet);

            if (!isAmountBetValid) {
                notificationService.sendError(bet.getAmountBet());

                if (!endService.IsContinue()) {
                    endService.end(wallet.getAmount());
                    break;
                } else {
                    continue;
                }
            }

            if (!isHorseBetValid) {
                notificationService.sendHorseBetError(bet.getHorseBet());

                if (!endService.IsContinue()) {
                    endService.end(wallet.getAmount());
                    break;
                } else {
                    continue;
                    }
                }

                notificationService.sendNotify(bet.getAmountBet());

                betService.winLose(bet);

                notificationService.endBalance(wallet);

                walletService.updateAmount(wallet.getAmount());

                if (!endService.IsContinue()) {
                    endService.end(wallet.getAmount());
                    break;
            }

        }
    }
}



