package com.example.kolos2.controller;

import com.example.kolos2.model.Klient;
import com.example.kolos2.servis.KlientServis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class KlientController {
    private final KlientServis servis;

    @GetMapping("/{id}")
    Klient getKlientById(@PathVariable long id) {
        Optional<Klient> klientByID = servis.getKlientByID(id);
        if (klientByID.isPresent()) {
            return klientByID.get();
        } else throw new IllegalArgumentException("brak usera");
    }

    @GetMapping("/{id}/oders")
    int getKlientOrders(@PathVariable long id) {
        return servis.getKlientOrders(id);
    }

    @GetMapping("/{id}/totalprice")
    double getTotalPrice(@PathVariable long id) {
        return servis.getTotalPrice(id);
    }

}
