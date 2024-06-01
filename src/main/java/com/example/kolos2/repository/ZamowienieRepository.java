package com.example.kolos2.repository;

import com.example.kolos2.model.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZamowienieRepository extends JpaRepository<Zamowienie,Long> {
}
