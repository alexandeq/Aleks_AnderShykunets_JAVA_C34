package org.example.web.dto;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private String name;
    private Instant birthdate;
    private String address;

}

//пользователь вводит данные для оформления заказа, при нажатии кнопки инфо переход на страницу, где отбражается текущее время