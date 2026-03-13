package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.Trip;

import java.util.List;

public interface TripService {
    Trip getTrip(Long id);
    List<Trip> getAllTrips();
    Trip createTrip(Trip employee);
    Trip updateTrip(Trip employee);
    void deleteTrip(Trip employee);
}
