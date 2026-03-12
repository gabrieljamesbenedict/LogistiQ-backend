package com.porado.LogistiQ.backend;

import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.repository.TripRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class LogistiQApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogistiQApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(TripRepository repository) {
        return (args) -> {
            if (repository.count() == 0) {
                Trip trip1 = new Trip();
                trip1.setOrigin("Manila");
                trip1.setDestination("Cebu");
                trip1.setStatus("IN_TRANSIT");
                trip1.setDriver("Juan Dela Cruz");
                trip1.setDate(LocalDateTime.now());
                trip1.setTotalExpenses(2500.0);
                trip1.setTotalProfit(5000.0);
                trip1.setCustomerName("ABC Logistics");
                repository.save(trip1);

                Trip trip2 = new Trip();
                trip2.setOrigin("Davao");
                trip2.setDestination("Baguio");
                trip2.setStatus("COMPLETED");
                trip2.setDriver("Maria Santos");
                trip2.setDate(LocalDateTime.now().minusDays(1));
                trip2.setTotalExpenses(1800.0);
                trip2.setTotalProfit(4200.0);
                trip2.setCustomerName("XYZ Trading");
                repository.save(trip2);

                System.out.println("Dummy trips loaded!");
            }
        };
    }
}