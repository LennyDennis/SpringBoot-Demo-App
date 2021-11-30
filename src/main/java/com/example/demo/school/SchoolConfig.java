package com.example.demo.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SchoolConfig {

    @Bean
    CommandLineRunner commandLineRunner(SchoolRepository schoolRepository){
        return args -> {
            School schoolOne = new School("Test School One");
            School schoolTwo = new School("Test School Two ");
            schoolRepository.saveAll(Arrays.asList(schoolOne,schoolTwo));
        };
    }
}
