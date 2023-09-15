package com.example.ecommerce.model;

import javax.persistence.*;
import java.util.Set;
import  com.example.ecommerce.model.OrderStatus;

@Entity
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private OrderStatus description;

    // Getters and setters

    public OrderStatus getDescription() {
        return description;
    }

    public void setDescription(OrderStatus description) {
        this.description = description;
    }

}