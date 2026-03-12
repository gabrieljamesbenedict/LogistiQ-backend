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
            // Only add stuff if the database is completely empty
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
                
                // Add as many dummy trips as you want here!
                System.out.println("Dummy trips loaded into the database!");
            }
        };
    }
}