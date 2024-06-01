package com.example.kolos2.controller;

import com.example.kolos2.model.Produkt;
import com.example.kolos2.servis.KlientServis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProduktController {
    private final KlientServis servis;

    @GetMapping
    Produkt getMost(){
        return servis.getMostCommonProdukt();
    }
}
