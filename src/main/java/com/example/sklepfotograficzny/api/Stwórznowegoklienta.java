package com.example.sklepfotograficzny.api;

import com.example.sklepfotograficzny.domain.Klient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class Stwórznowegoklienta {
    private final com.example.sklepfotograficzny.domain.repository.Bazaklientow Bazaklientow;
    Klient Stworznowegoklienta(Dodajnowegoklienta dodajnowegoklienta) {
        return Bazaklientow.save(new Klient(dodajnowegoklienta.getImie(),
                dodajnowegoklienta.getAdres()));
    }
}
