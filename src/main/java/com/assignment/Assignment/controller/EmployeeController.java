package com.assignment.Assignment.controller;

import com.assignment.Assignment.controller.Request.EmployeeRequest;
import com.assignment.Assignment.entity.Employee;
import com.assignment.Assignment.service.EmployeeService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping
    @ResponseBody
    public Employee saveEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws BadRequestException {
        return this.employeeService.saveEmployee(employeeRequest);
    }
}
