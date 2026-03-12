package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployerService employerService;

    @Autowired
    public EmployeeController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Employee addDriver(@RequestBody Employee employee) {
        return employerService.addDriver(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllDrivers() {
        return employerService.getAllDrivers();
    }
}