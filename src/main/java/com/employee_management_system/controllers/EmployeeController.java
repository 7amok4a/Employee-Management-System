package com.employee_management_system.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management_system.dtos.EmployeeCreate;
import com.employee_management_system.dtos.EmployeeUpdate;
import com.employee_management_system.models.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String hello() {
        return "hello" ; 
    }

    // CRUD Operation 

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeCreate employeeCreate) {
        Employee employee = new Employee() ; 
        return new ResponseEntity<>(employee, HttpStatus.CREATED) ; 
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable UUID employeeId) {
        return null ; 
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees () {
        return null ; 
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updatEmployee(@RequestBody @Valid EmployeeUpdate employeeUpdate, 
        @PathVariable UUID employeeId
    ) {
        return null ; 
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
}
