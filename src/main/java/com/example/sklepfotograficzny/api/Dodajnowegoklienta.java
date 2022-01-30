package com.example.sklepfotograficzny.api;
import com.example.sklepfotograficzny.domain.Adres;
import lombok.Value;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class Dodajnowegoklienta {
    @NotNull
    Adres adres;
    @NotEmpty
    String Imie;

}
