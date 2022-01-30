package com.example.sklepfotograficzny.api;


import com.example.sklepfotograficzny.domain.Wypożyczenie;
import com.example.sklepfotograficzny.domain.repository.Bazaklientow;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Wynajm")
@AllArgsConstructor
public class WypożyczenieAktywne {

    private Wynajm wynajm;
    private Bazaklientow bazaklientow;


    @GetMapping("/userRentals/{id}")
    public List<Wypożyczenie> getUserRentals(@PathVariable Long id) {
        return bazaklientow.findById(id).get().getWypożyczeniaKlienta();
    }

    @PostMapping("/newRental/{id}/{AparatId}")
    public Wypożyczenie createNewRental(@PathVariable Long id, @PathVariable Long AparatId, @RequestBody @Valid Danewypożyczenia danewypożyczenia) {
        return wynajm.WyporzyczAAparat(id, AparatId, danewypożyczenia);
    }


    @PostMapping("/endRental/{id}")
    public void endRental(@PathVariable Long id) {
        wynajm.endRental(id);
    }


}
