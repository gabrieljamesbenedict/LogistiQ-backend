package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployerService employerService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getEmployee(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employerService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employerService.createEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employerService.updateEmployee(employee));
    }

    @DeleteMapping
    public void deleteEmployee(@RequestBody Employee employee) {
        employerService.deleteEmployee(employee);
    }

//    @PostMapping("/add")
//    public Employee addDriver(@RequestBody Employee employee) {
//        return employerService.addDriver(employee);
//    }
//
//    @GetMapping("/all")
//    public List<Employee> getAllDrivers() {
//        return employerService.getAllDrivers();
//    }
}