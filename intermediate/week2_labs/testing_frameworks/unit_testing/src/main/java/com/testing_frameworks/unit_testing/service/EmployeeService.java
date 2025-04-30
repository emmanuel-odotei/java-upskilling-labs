package com.testing_frameworks.unit_testing.service;

import com.testing_frameworks.unit_testing.entity.Employee;

public interface EmployeeService {
    Employee addEmployee (Employee employee);
    
    Employee findEmployee (Integer id);
}
