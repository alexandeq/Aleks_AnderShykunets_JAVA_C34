package org.example.service.impl;

import org.example.service.FootballActivity;

public class PlayFootballImpl implements FootballActivity {

    @Override
    public void action(String message) {
        System.out.println("Lets play football");

    }
}
