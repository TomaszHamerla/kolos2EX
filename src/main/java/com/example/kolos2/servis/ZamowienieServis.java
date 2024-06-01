package com.example.kolos2.servis;

import com.example.kolos2.repository.ZamowienieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZamowienieServis {
    private final ZamowienieRepository repository;
}
