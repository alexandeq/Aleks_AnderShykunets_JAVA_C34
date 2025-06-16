package org.example.sql;

//Сергей добрый день,я пользуюсь приложением DBeaver.
// насколько я понял эту домашку нужно оформлять так

create table persons (

        id bigserial primary key,
        name varchar,
        password varchar,
        age int

);


drop table persons;

insert into persons(name, password, age) values ('Denis', 'abcd123', 26),
                                                ('Maria', null, 30),
                                                ('Oleg', 'qwerty', 52);

update persons set password = 'password2' where name = 'Maria';


select * from persons where age >= 30;


delete from persons;