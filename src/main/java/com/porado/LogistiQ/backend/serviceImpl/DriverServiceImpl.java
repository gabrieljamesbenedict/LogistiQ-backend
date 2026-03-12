package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.DriverService;
import com.porado.LogistiQ.backend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Employee addDriver(Employee employee) {
        return driverRepository.save(employee);
    }

    @Override
    public List<Employee> getAllDrivers() {
        return driverRepository.findAll();
    }
}