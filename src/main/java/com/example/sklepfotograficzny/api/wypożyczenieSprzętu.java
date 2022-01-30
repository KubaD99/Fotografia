package com.example.sklepfotograficzny.api;

import com.example.sklepfotograficzny.domain.Aparat;
import com.example.sklepfotograficzny.domain.repository.BazaAparatow;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Aparat")
public class wypożyczenieSprzętu {

    private final BazaAparatow AparatRepository;
    @GetMapping("/{id}")
    public Aparat getAparat(@PathVariable Long id) {
        return AparatRepository.getById(id);
    }
    @PostMapping
    public Aparat dodajeAparat(@RequestBody Aparat Aparat) {
        return AparatRepository.save(Aparat);
    }
    @GetMapping
    public List<Aparat> getAllAparaty() {
        return AparatRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteAparat(@PathVariable Long id) {AparatRepository.deleteById(id);
    }
    @GetMapping("/dostepny")
    public List<Aparat> getAllAvailableAparaty() {
        return AparatRepository.findByIsRentedFalse();
    }
}
