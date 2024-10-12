package com.school.database.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase 
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(StudentRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Student("Kivanc Onat Turker", "Computer Science",21)));
      log.info("Preloading " + repository.save(new Student("Hasan Ali Karaca", "Electric Engineer",21)));
    };
  }
}
