package org.example.projekt69;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Ten fragment kodu uruchomi się automatycznie po starcie
/*    @Bean
    CommandLineRunner initDatabase(DaneRepository repository) {
        return args -> {
            Dane z1 = new Dane();
            z1.setTemperatura(12);
            z1.setData(LocalDate.now());
            z1.setGodzina(LocalTime.now());

            repository.save(z1);
            System.out.println("Dane testowe zostały zapisane w SQL!");
        };
    } */
}