package org.example;

import org.example.domain.Wallet;
import org.example.domain.Horse;
import org.example.service.RaceHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        RaceHandler bean = context.getBean(RaceHandler.class);
        Wallet wallet = new Wallet();
        Scanner in = new Scanner(System.in);

        while (true) {
        System.out.println("Ваш баланс: " + wallet.getAmount());
        System.out.println("Список имеющихся лошадей: " + Horse.getHorses());

        System.out.print("Введите сумму ставки: ");
        wallet.setAmountBet(in.nextInt());

        System.out.print("Введите номер лошади: ");
        wallet.setHorseBet(in.nextInt());

        bean.startRace(wallet);

        System.out.print("Хотите сделать еще ставку? (да/нет): ");


        if (!in.next().equalsIgnoreCase("да")) {
            break;
            }
        }

        in.close();
        System.out.println("Спасибо за игру! Итоговый баланс: " + wallet.getAmount());

    }
}
