package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.repository.TripRepository;
import com.porado.LogistiQ.backend.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    @Override
    public Trip getTrip(Long id) {
        return tripRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip does not exist"));
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip createTrip(Trip trip) {
        if (trip.getTripId() != null) throw new IllegalStateException("Cannot create a new Trip record");
        return tripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        if (trip.getTripId() == null) throw new IllegalStateException("Cannot update on null ID");
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(Trip trip) {
        Trip t = getTrip(trip.getTripId());
        tripRepository.delete(t);
    }
}
