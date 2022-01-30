package com.example.sklepfotograficzny.domain.repository;

import com.example.sklepfotograficzny.domain.Aparat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BazaAparatow extends JpaRepository<Aparat,Long> {

    List<Aparat> findByIsRentedFalse();
}
