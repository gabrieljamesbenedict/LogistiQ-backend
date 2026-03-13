package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTrip(id));
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.createTrip(trip));
    }

    @PutMapping
    public ResponseEntity<Trip> updateTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.updateTrip(trip));
    }

    @DeleteMapping
    public void deleteTrip(@RequestBody Trip trip) {
        tripService.deleteTrip(trip);
    }

//    @GetMapping
//    public List<Trip> getAllTrips() {
//        return tripRepository.findAll();
//    }
//
//    @PostMapping
//    public Trip createTrip(@RequestBody Trip trip) {
//        return tripRepository.save(trip);
//    }
}