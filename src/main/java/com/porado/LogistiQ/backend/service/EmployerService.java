package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.Employee;

import java.util.List;

public interface EmployerService {
    Employee getEmployee(Long id);
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}