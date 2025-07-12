package org.example.service.impl;

import org.example.domain.Horse;
import org.example.domain.Wallet;
import org.example.service.BetService;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Random;

@Service
public class BetServiceImpl implements BetService {
    @Override
    public void winLose(Wallet wallet) {

        var bet = wallet.getAmountBet();

        Random random = new Random();
        var randomHorse = Horse.getHorses().get(random.nextInt(Horse.getHorses().size()));

        if (Objects.equals(randomHorse, wallet.getHorseBet())) {
            wallet.setAmount(wallet.getAmount() + (bet * 2));
            System.out.println("Вы угадали. Победила лошадь №" + randomHorse);
            System.out.println("Ваш выйгрыш: " + (bet * 2));
        } else {
            wallet.setAmount(wallet.getAmount() - bet);
            System.out.println("Вы проиграли. Победила лошадь №" + randomHorse);
        }

    }
}
