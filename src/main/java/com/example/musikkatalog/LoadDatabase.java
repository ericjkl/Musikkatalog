package com.example.musikkatalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MusikstueckRepository repository)
    {

        return args -> {
            log.info("Preloading " + repository.save(new Musikstueck("CD", "Niemand", "Test", "Pop", 2000)));
            log.info("Preloading " + repository.save(new Musikstueck("Schallplatte", "Moneyboy", "Monte Carlo", "Rap", 2002)));
        };
    }
}
