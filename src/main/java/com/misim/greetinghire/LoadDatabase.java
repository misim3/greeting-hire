package com.misim.greetinghire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PositionRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Position("Doodlin", "QA Engineer", "5 years", "part time", null, null)));
            log.info("Preloading " + repository.save(new Position("Classum", "Backend Engineer", "junior", "intern", null, null)));
        };
    }
}