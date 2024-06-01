package com.example.kolos2.repository;

import com.example.kolos2.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduktRepository extends JpaRepository<Produkt,Long> {
}
