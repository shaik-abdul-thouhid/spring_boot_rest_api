package com.spring_rest_application.spring_boot_rest_api.student;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student mariam = new Student("Mariam", "mariam.jamal@gmail.com", LocalDate.of(2000, JANUARY, 5));
			Student alex = new Student("Alex", "alex.jamal@gmail.com", LocalDate.of(2004, JANUARY, 5));

			repository.saveAll(List.of(mariam, alex));
		};
	}
}
