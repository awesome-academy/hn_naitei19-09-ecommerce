package com.example.ecommerce.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Reasons")
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    // Getters and setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}