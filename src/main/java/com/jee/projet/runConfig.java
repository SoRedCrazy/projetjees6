package com.jee.projet;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class runConfig {
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
        };
    }

}
