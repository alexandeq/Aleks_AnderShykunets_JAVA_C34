package org.example.service;

import org.example.domain.Wallet;

public interface NotificationService {

    void sendNotify(Integer bet);

    void sendError(Integer bet);

    void sendHorseBetError(Integer bet);

    void endBalance(Wallet wallet);

}
