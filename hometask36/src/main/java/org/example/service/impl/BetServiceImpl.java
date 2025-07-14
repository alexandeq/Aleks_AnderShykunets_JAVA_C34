package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Horse;
import org.example.domain.Wallet;
import org.example.service.BetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class BetServiceImpl implements BetService{

    private final Wallet wallet;
    private final List<Horse> horsesList;


    @Override
    public void winLose(Bet bet) {

        var amountBet = bet.getAmountBet();

        Random random = new Random();
        Horse randomHorse = horsesList.get(random.nextInt(horsesList.size()));


        if (randomHorse.getName().equals(String.valueOf(bet.getHorseBet()))){

            wallet.setAmount(wallet.getAmount() + (amountBet * 2));
            System.out.println("Вы угадали. Победила лошадь №" + randomHorse.getName());
            System.out.println("Ваш выйгрыш: " + (amountBet * 2));
        } else {
            wallet.setAmount(wallet.getAmount() - amountBet);
            System.out.println("Вы проиграли. Победила лошадь №" + randomHorse.getName());
        }

    }
}
