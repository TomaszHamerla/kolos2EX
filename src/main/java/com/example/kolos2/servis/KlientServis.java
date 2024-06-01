package com.example.kolos2.servis;

import com.example.kolos2.model.Klient;
import com.example.kolos2.model.Produkt;
import com.example.kolos2.model.Zamowienie;
import com.example.kolos2.repository.KlientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KlientServis {
    private final KlientRepository repository;

   public Optional<Klient> getKlientByID(long id) {
        return repository.findById(id);
    }

   public int getKlientOrders(long id) {
        Optional<Klient> klientByID = getKlientByID(id);
        return klientByID.isPresent() ? klientByID.get().getOrders().size() : -1;
    }

   public double getTotalPrice(long id) {
        Optional<Klient> klientByID = getKlientByID(id);
        double totalPrice = 0;
        if (klientByID.isPresent()) {
            totalPrice = klientByID.get().getTotalPrice();
        }
        return totalPrice;
    }

   public Produkt getMostCommonProdukt() {
        List<Klient> klients = repository.findAll();
        List<Klient> list = klients.stream().filter((k) -> !k.getOrders().isEmpty()).toList();
        List<Zamowienie> list1 = list.stream().flatMap((k) -> k.getOrders().stream()).toList();
        List<Produkt> list2 = list1.stream().flatMap((z) -> z.getProducts().stream()).toList();
        Optional<Produkt> produkt = list2.stream().collect(Collectors.groupingBy((p) -> p, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        return produkt.get();
    }

}
