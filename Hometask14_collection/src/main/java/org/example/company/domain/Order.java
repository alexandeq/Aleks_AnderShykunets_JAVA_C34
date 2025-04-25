package org.example.company.domain;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Order  {

    private String id;
    private String order;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return Objects.equals(id, order1.id) && Objects.equals(order, order1.order) && Objects.equals(status, order1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, status);
    }


}
