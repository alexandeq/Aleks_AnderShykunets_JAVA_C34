package domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Car {

    private Integer id;
    private String model;
    private Integer price;

    public Car(String model, Integer price) {
        this.model = model;
        this.price = price;

    }
}
