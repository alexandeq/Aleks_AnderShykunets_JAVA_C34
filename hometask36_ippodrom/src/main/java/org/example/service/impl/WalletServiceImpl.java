package org.example.service.impl;

import org.example.domain.Wallet;
import org.example.service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private final Wallet wallet = new Wallet();

    @Override
    public void updateAmount(Integer newAmount) {
        wallet.setAmount(newAmount);
    }

}
