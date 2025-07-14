package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.Wallet;
import org.example.service.WalletService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final Wallet wallet;

    @Override
    public void updateAmount(Integer newAmount) {
        wallet.setAmount(newAmount);
    }

}
