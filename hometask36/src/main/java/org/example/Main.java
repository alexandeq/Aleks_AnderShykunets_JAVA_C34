package org.example;

import org.example.domain.Bet;
import org.example.domain.Wallet;
import org.example.service.RaceHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        Bet bet = new Bet();
        Wallet wallet = new Wallet();

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        RaceHandler bean = context.getBean(RaceHandler.class);
        bean.startRace(bet);

    }
}
