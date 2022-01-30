package com.example.sklepfotograficzny;

import com.example.sklepfotograficzny.domain.Klient;
import com.example.sklepfotograficzny.domain.repository.Bazaklientow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SklepFotograficznyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SklepFotograficznyApplication.class, args);
    }


    @Bean
    public CommandLineRunner dataInitializer(Bazaklientow bazaklientow) {
        return (args) -> bazaklientow.save(new Klient("klient", null));
    }
}
