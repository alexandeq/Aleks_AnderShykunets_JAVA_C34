package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Horse;
import org.example.domain.Wallet;
import org.example.service.BetService;
import org.example.service.StartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class StartServiceImpl implements StartService {

    private final Wallet wallet;
    private final List<Horse> horsesList;

    @Override
    public void start(Bet bet) {
        Bet newBet = new Bet();
        Scanner in = new Scanner(System.in);

        System.out.println("Ваш баланс: " + wallet.getAmount());
        System.out.println("Список имеющихся лошадей:");
        for (Horse horse : horsesList) {
            System.out.println(horse.getName());
        }

        System.out.print("Введите сумму ставки: ");
        bet.setAmountBet(in.nextInt());

        System.out.print("Введите номер лошади: ");
        bet.setHorseBet(in.nextInt());

    }
}
