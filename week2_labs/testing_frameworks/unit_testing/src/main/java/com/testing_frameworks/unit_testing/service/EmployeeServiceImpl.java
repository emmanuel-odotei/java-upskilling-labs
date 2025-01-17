package com.testing_frameworks.unit_testing.service;

import com.testing_frameworks.unit_testing.entity.Employee;
import com.testing_frameworks.unit_testing.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addEmployee (Employee employee) {
        return employeeRepository.save( employee );
    }
    
    @Override
    public Employee findEmployee (Integer id) {
        return employeeRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Employee not found" ) );
    }
}
