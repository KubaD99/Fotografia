package com.example.sklepfotograficzny.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode
@Getter
@Entity
public class Klient {


    public Klient(String imie, Adres adres) {
        this.imie = imie;
        this.adres = adres;
        this.WypożyczeniaKlienta = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    Long id;

    String imie;

    @OneToOne(cascade = CascadeType.ALL)
    Adres adres;

    @OneToMany(cascade = CascadeType.ALL)
    List<Wypożyczenie> WypożyczeniaKlienta;

    public void addRental(Wypożyczenie rental){
        WypożyczeniaKlienta.add(rental);
    }






}
