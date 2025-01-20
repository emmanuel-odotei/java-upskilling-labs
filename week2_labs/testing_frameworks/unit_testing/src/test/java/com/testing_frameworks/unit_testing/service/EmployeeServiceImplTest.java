package com.testing_frameworks.unit_testing.service;

import com.testing_frameworks.unit_testing.entity.Employee;
import com.testing_frameworks.unit_testing.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class EmployeeServiceImplTest {
    
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    
    @Mock
    private EmployeeRepository employeeRepository;
    
    Integer employeeId = 1;
    Employee employee = new Employee(employeeId, "John Doe","doe.john@gmail.com", "Software Engineer");
    @Test
    void addEmployee () {
        when(employeeRepository.save( employee )).thenReturn( employee );
        
        Employee savedEmployee = employeeService.addEmployee( employee );
        assertEquals( employee, savedEmployee );
        verify( employeeRepository ).save( employee );
    }
    
    @Test
    void findEmployee () {
        when(employeeRepository.findById( employeeId )).thenReturn( java.util.Optional.of( employee ) );
        
        Employee foundEmployee = employeeService.findEmployee( employeeId );
        assertEquals( employee, foundEmployee );
        verify( employeeRepository ).findById( employeeId );
    }
    
    @Test
    void testGetEmployeeById_EmployeeDoesNotExist() {
        
        when(employeeRepository.findById(employeeId)).thenReturn( Optional.empty());
        
        assertThrows(RuntimeException.class, () -> employeeService.findEmployee(employeeId));
        verify(employeeRepository, times(1)).findById(employeeId);
    }
}