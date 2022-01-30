package com.example.sklepfotograficzny.domain.repository;

import com.example.sklepfotograficzny.domain.Klient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Bazaklientow extends JpaRepository<Klient, Long> {
}
