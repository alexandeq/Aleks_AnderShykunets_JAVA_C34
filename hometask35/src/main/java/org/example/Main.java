package org.example;

import org.example.domain.Person;
import org.example.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        var bean = context.getBean(PersonService.class);

        bean.doSomething(person);

    }
}
