package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.Driver;
import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    List<Driver> getAllDrivers();
}