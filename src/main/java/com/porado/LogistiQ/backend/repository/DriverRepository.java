package com.porado.LogistiQ.backend.repository;

import com.porado.LogistiQ.backend.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    
}