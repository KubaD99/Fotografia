package com.example.sklepfotograficzny.api;

import lombok.Value;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class Danewypożyczenia {
    @NotNull
    @Min(0)
    Double cena;
    @Future
    LocalDate dokiedy;
    @NotNull
    @Future
    LocalDate skad;

}
