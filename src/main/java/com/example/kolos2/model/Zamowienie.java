package com.example.kolos2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@NoArgsConstructor
@Data
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Klient klient;
    @OneToMany(mappedBy = "zamowienie")
    private List<Produkt> products = new ArrayList<>();


    public Zamowienie(Klient klient) {
        this.klient = klient;
    }

    double getTotalPrice(){
    return products.stream().mapToDouble(Produkt::getPrice).sum();
    }
}
