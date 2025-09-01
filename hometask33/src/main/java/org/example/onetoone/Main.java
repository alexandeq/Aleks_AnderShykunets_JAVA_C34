package org.example.onetoone;

import org.example.onetoone.entity.PassportEntity;
import org.example.onetoone.entity.PersonEntity;
import org.example.onetoone.service.PersonService;

import java.util.UUID;


public class Main {

    private static final PersonService service = new PersonService();

    public static void main(String[] args) {

        var passport = new PassportEntity("KH", 5568814);

        var user = new PersonEntity("Denis", "Smirnov");
        user.setPassport(passport);

        var byId = service.findById(UUID.fromString("e8f72953-7901-480b-b19c-4c50a7c83342"));
        var save = service.save(user);

        System.out.println("Name is: " + byId.getName());
        System.out.println(save);

    }
}