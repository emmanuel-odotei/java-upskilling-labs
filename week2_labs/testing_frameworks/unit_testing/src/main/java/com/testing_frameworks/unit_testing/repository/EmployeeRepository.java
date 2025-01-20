package com.testing_frameworks.unit_testing.repository;

import com.testing_frameworks.unit_testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
