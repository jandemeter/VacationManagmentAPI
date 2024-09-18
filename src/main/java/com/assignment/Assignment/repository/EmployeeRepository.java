package com.assignment.Assignment.repository;

import com.assignment.Assignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByTeamId(Long teamId);
}
