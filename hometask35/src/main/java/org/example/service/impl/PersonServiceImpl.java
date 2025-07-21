package org.example.service.impl;

import org.example.domain.Person;
import org.example.service.FootballActivity;
import org.example.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private final FootballActivity activity;

    public PersonServiceImpl(FootballActivity activity) {
        this.activity = activity;
    }

    @Override
    public void doSomething(Person person) {
        System.out.println("Person do something");
        activity.action("Action");
    }

    public void setup(){
        System.out.println("Custom init method");
    }
}
