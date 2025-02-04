package com.school.database.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.school.database.school.enums.Grade;
import com.school.database.school.model.Student;
import com.school.database.school.model.Teacher;
import com.school.database.school.repository.StudentRepository;
import com.school.database.school.repository.TeacherRepository;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(StudentRepository studentRepository, TeacherRepository teacherRepository,
      PasswordEncoder encoder) {

    return args -> {
      log.info("Preloading " + studentRepository
          .save(new Student("kivanc", encoder.encode("kivanc"), "kivanc@mail", "Kivanc Onat Turker", "Computer Science",
              21, Grade.SENIOR)));
      log.info("Preloading " + studentRepository
          .save(new Student("hasan", encoder.encode("hasan"), "hasan@mail", "Hasan Ali Karaca", "Electric Engineer",
              21, Grade.JUNIOR)));

      log.info("Preloading " + teacherRepository.save(new Teacher("gurhan", encoder.encode("gurhan"), "gurhan@mail",
          "Gurhan Kucuk", "Computer Science", "Professor")));
      log.info("Preloading "
          + teacherRepository.save(new Teacher("tacha", encoder.encode("tacha"), "tacha@mail", "Tacha Sheriff",
              "Computer Science", "Associate Professor")));
    };
  }
}
