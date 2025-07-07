package org.example.domain;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Person {

    private Integer id;
    private String name;
    private String sex;
    private String size;

}
