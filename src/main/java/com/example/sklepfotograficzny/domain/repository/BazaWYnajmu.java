package com.example.sklepfotograficzny.domain.repository;

import com.example.sklepfotograficzny.domain.Wypożyczenie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BazaWYnajmu extends JpaRepository<Wypożyczenie, Long> {

}
