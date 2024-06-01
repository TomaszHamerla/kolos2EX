package com.example.kolos2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "clients")
@NoArgsConstructor
@Data
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int number;
    @OneToMany(mappedBy = "klient")
    private List<Zamowienie> orders = new ArrayList<>();

    public Klient(String name, String lastName, String email, int number) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
    }
   public double getTotalPrice(){
       return orders.stream().mapToDouble(Zamowienie::getTotalPrice).sum();
    }
}
