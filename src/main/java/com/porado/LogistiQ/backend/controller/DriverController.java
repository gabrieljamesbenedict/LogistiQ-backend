package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "http://localhost:3000")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add")
    public Employee addDriver(@RequestBody Employee employee) {
        return driverService.addDriver(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllDrivers() {
        return driverService.getAllDrivers();
    }
}