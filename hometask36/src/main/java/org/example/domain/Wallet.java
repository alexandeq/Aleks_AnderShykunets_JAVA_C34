package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Wallet {

    private Integer amount = 5000;


}