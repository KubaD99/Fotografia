package com.example.sklepfotograficzny.api;

import com.example.sklepfotograficzny.domain.Klient;
import com.example.sklepfotograficzny.domain.Wypożyczenie;
import com.example.sklepfotograficzny.domain.repository.BazaAparatow;
import com.example.sklepfotograficzny.domain.repository.Bazaklientow;
import com.example.sklepfotograficzny.domain.repository.BazaWYnajmu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@AllArgsConstructor
public class Wynajm {

    private BazaWYnajmu baza;
    private Bazaklientow KlientBaza;
    private BazaAparatow AparatBaza;


    public Wypożyczenie WyporzyczAAparat(Long customerId, Long AparatId, Danewypożyczenia danewypożyczenia) {
        final Klient klient = KlientBaza.findById(customerId).orElseThrow(KlientNotFoundException::new);
        final com.example.sklepfotograficzny.domain.Aparat aparat = AparatBaza.findById(AparatId).orElseThrow(Aparat::new);
        Wypożyczenie newRental = new Wypożyczenie(aparat, danewypożyczenia.getSkad(), danewypożyczenia.getDokiedy(), danewypożyczenia.getCena());
        klient.addRental(newRental);
        aparat.setRented(true);
        newRental.setIsActive(true);
        return baza.save(newRental);
    }
    public void endRental(Long rentalId) {
        final Wypożyczenie rental = baza.findById(rentalId).orElseThrow(WypożyczenieNotFoundException::new);
        com.example.sklepfotograficzny.domain.Aparat aparat = rental.getAparat();
        aparat.setRented(false);
        rental.setIsActive(false);
        baza.deleteById(rentalId);
    }
    @ResponseStatus(value = NOT_FOUND, reason = "Wypożyczenie not found")
    private static class WypożyczenieNotFoundException extends RuntimeException {

    }
    @ResponseStatus(value = NOT_FOUND, reason = "Aparat not found")
    private static class Aparat extends RuntimeException {
    }

    @ResponseStatus(value = NOT_FOUND, reason = "Klient not found")
    private static class KlientNotFoundException extends RuntimeException {
    }

}
