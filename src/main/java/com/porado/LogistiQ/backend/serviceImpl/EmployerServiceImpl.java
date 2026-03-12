package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.EmployerService;
import com.porado.LogistiQ.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployerServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addDriver(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllDrivers() {
        return employeeRepository.findAll();
    }
}