package org.example.service.impl;

import org.example.domain.Wallet;
import org.example.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotify(Integer bet) {
        System.out.printf("Ваша ставка < %s > принята\n", bet);
        System.out.println("Забег начался..........");
        System.out.println("Лошадь №1: ------------\uD83D\uDC0E");
        System.out.println("Лошадь №2: -----------\uD83D\uDC0E");
        System.out.println("Лошадь №3: ----------\uD83D\uDC0E");
        System.out.println("Лошадь №4: ------------\uD83D\uDC0E");
        System.out.println("Лошадь №5: ---------\uD83D\uDC0E");

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            System.out.println(e);;
        }
    }

    @Override
    public void sendError(Integer bet) {
        System.out.println("Ошибка, некоректная сумма");
    }

    @Override
    public void sendHorseBetError(Integer bet) {
        System.out.println("Ошибка, неправильный номер лошади ");
    }

    @Override
    public void endBalance(Wallet wallet) {
        System.out.println("Итоговый баланс: " + wallet.getAmount());
    }

}

