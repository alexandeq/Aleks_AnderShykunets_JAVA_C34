package org.example.service;

import org.example.domain.Bet;

public interface EndService {

    boolean IsContinue();

    void end(Integer amount);
}
