package com.example.kolos2;

import com.example.kolos2.model.Klient;
import com.example.kolos2.model.Produkt;
import com.example.kolos2.model.Zamowienie;
import com.example.kolos2.repository.KlientRepository;
import com.example.kolos2.repository.ProduktRepository;
import com.example.kolos2.repository.ZamowienieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private final KlientRepository klientRepository;
    private final ProduktRepository produktRepository;
    private final ZamowienieRepository zamowienieRepository;

    @Override
    public void run(String... args) throws Exception {
        Klient klient = new Klient("Jan", "Kowalski", "ja@", 123);
        Klient klient1 = new Klient("Adam", "Nowak", "ad@", 456);

        Produkt produkt = produktRepository.save(new Produkt("Produkt1", "Opis1", 10.0));
        Produkt produkt1 = produktRepository.save(new Produkt("Produkt2", "Opis2", 20.0));
        Produkt produkt2 = produktRepository.save(new Produkt("Produkt3", "Opis3", 30.0));
        Produkt produkt3 = produktRepository.save(new Produkt("Produkt4", "Opis4", 40.0));
        Produkt produkt4 = produktRepository.save(new Produkt("Produkt5", "Opis5", 50.0));
        Produkt produkt5 = produktRepository.save(new Produkt("Produkt6", "Opis6", 60.0));

        Zamowienie zamowienie = new Zamowienie();
        zamowienie.getProducts().add(produkt);
        zamowienie.getProducts().add(produkt1);
        zamowienie.getProducts().add(produkt2);

        Zamowienie zamowienie1 = new Zamowienie();
        zamowienie1.getProducts().add(produkt3);
        zamowienie1.getProducts().add(produkt4);
        zamowienie1.getProducts().add(produkt5);

        klient.getOrders().add(zamowienie);
        klient1.getOrders().add(zamowienie1);

        klientRepository.save(klient);
        klientRepository.save(klient1);
    }
}
