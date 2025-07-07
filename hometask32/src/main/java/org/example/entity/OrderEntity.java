package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter @Setter
@ToString
public class OrderEntity {

    @Id
    @UuidGenerator
    private UUID id;
    @Column(length = 1024)
    private String name;
    @Enumerated(EnumType.STRING)
    private  Type type;
    @CreationTimestamp
    private Instant created;
    @Embedded
    private Address address ;
    private Long price;
    @Column(name = "is_priority")
    private boolean isPriority;

    public OrderEntity(String name, Type type, Instant created, Address address, Long price, boolean isPriority) {
        this.name = name;
        this.type = type;
        this.created = created;
        this.address = address;
        this.price = price;
        this.isPriority = isPriority;
    }

}

