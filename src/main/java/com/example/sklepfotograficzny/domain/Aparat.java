package com.example.sklepfotograficzny.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import static lombok.AccessLevel.PRIVATE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
public class Aparat {

    public Aparat(String marka, String model) {
        this.marka = marka;
        this.model = model;

    }

    @Id
    @GeneratedValue
    Long id;

    String marka;

    String model;

    @Setter
    boolean isRented;


}
