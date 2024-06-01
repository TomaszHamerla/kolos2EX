package com.example.kolos2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "products")
@NoArgsConstructor
@Data
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Zamowienie zamowienie;

    public Produkt(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
