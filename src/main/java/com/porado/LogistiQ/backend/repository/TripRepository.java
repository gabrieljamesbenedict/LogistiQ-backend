package com.porado.LogistiQ.backend.repository;

import com.porado.LogistiQ.backend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}