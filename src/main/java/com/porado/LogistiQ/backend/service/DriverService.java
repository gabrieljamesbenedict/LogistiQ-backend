package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.Employee;

import java.util.List;

public interface DriverService {
    Employee addDriver(Employee employee);
    List<Employee> getAllDrivers();
}