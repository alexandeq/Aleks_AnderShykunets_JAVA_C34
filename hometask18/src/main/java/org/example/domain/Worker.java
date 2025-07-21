package org.example.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString

public class Worker {

    private Profession profession;
    private Integer salary;


}
