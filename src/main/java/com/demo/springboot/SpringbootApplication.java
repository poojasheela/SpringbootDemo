package com.demo.springboot;

import com.demo.springboot.Student;
import com.demo.springboot.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			if (studentRepository.count() == 0) {
				studentRepository.save(new Student("Alice", "alice@gmail.com", "pass123", "Java"));
				studentRepository.save(new Student("Bob", "bob@gmail.com", "bobpass", "Python"));
				studentRepository.save(new Student("Charlie", "charlie@gmail.com", "charlie123", "Spring Boot"));
				studentRepository.save(new Student("Diana", "diana@gmail.com", "dianapass", "Angular"));
				System.out.println("Dummy students added.");
			}
		};
	}
}

