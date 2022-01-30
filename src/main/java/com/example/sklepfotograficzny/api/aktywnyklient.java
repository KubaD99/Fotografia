package com.example.sklepfotograficzny.api;


import com.example.sklepfotograficzny.domain.Klient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/klient")
public class aktywnyklient {
    Stwórznowegoklienta stwórznowegoklienta;
    @PostMapping
    public Klient addNewCustomer(@RequestBody Dodajnowegoklienta customer) {
        return stwórznowegoklienta.Stworznowegoklienta(customer);
    }
}
