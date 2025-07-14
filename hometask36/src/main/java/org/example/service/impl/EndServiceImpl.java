package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Bet;
import org.example.domain.Wallet;
import org.example.service.EndService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class EndServiceImpl implements EndService {

    private final Wallet wallet;
    Scanner in = new Scanner(System.in);

    @Override
    public boolean IsContinue() {
        System.out.print("Хотите сделать еще ставку? (да/нет): ");
        return in.next().equalsIgnoreCase("да");
    }

    @Override
    public void end(Integer amount) {
        System.out.println("Спасибо за игру! Итоговый баланс: " + wallet.getAmount());


    }

        }






