package com.example.sklepfotograficzny.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = PRIVATE)
@Entity
@Setter
public class Wypożyczenie {
    public Wypożyczenie(Aparat aparat, LocalDate od, LocalDate dokiedy, Double cena) {
        this.aparat = aparat;
        this.start = od;
        this.koniec = dokiedy;
        this.cena = cena;
    }
    @Id
    @GeneratedValue
    Long id;
    @OneToOne(cascade = CascadeType.ALL)
    Aparat aparat;
    LocalDate start;
    Double cena;
    LocalDate koniec;
    Boolean isActive;


}
