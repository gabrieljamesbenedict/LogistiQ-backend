package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Employee;
import com.porado.LogistiQ.backend.service.EmployerService;
import com.porado.LogistiQ.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(Long id){
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Employee does not exist"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getEmployeeId() != null) throw new IllegalStateException("Cannot create a new Employee record");
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getEmployeeId() == null) throw new IllegalStateException("Cannot update on null ID");
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Employee e = getEmployee(employee.getEmployeeId());
        employeeRepository.delete(e);
    }
}