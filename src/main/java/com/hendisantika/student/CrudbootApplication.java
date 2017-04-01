package com.hendisantika.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hendisantika.student.model.Student;
import com.hendisantika.student.repository.StudentRepository;

@SpringBootApplication
public class CrudbootApplication {

    private static final Logger log = LoggerFactory.getLogger(CrudbootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudbootApplication.class, args);
    }

    /**
     * Save students to H2 DB for testing
     *
     * @param repository
     * @return
     */
    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {
            // save students
            repository.save(new Student("Hendi", "Santika", "IT", "hendisantika@konohagakure.com"));
            repository.save(new Student("Uzumaki", "Naruto", "IT", "uzumaki_naruto@konohagakure.com"));
            repository.save(new Student("Hatake", "Kakashi", "IT", "kakahis_hatake@konohagakure.com"));
            repository.save(new Student("Sakura", "Haruno", "Nursery", "sakura_haruno@konohagakure.com"));
            repository.save(new Student("Sasuke", "Uchiha", "Business", "sasuke_uchiha@konohagakure.com"));
        };
    }
}
