package com.example.kolos2.servis;

import com.example.kolos2.repository.ProduktRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduktServis {
    private final ProduktRepository repository;


}
