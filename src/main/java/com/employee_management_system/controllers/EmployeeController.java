package com.employee_management_system.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.employee_management_system.services.EmployeeService;
import com.employee_management_system.shared.GlobalResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService ; 

    @GetMapping("/hello")
    public String hello() {
        return "hello" ; 
    }

    // CRUD Operation 

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> createEmployee(@RequestBody @Valid EmployeeCreate employeeCreate) {
        Employee employee = employeeService.createEmployee(employeeCreate); 
        return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.CREATED) ; 
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> findEmployeeById(@PathVariable UUID employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId) ; 
        return new ResponseEntity<>(new GlobalResponse<>(employee) , HttpStatus.OK); 
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> findAllEmployees () {
        List<Employee> employees = employeeService.findALll() ; 
        return new ResponseEntity<>(new GlobalResponse< >(employees) , HttpStatus.OK) ; 
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Employee>> updatEmployee(@RequestBody @Valid EmployeeUpdate employeeUpdate, 
        @PathVariable UUID employeeId
    ) {

        Employee employee = employeeService.updateEmployee(employeeUpdate, employeeId) ; 
        return new ResponseEntity<>(new GlobalResponse<>(employee) , HttpStatus.OK) ; 
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<GlobalResponse<Void>> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(null), HttpStatus.NO_CONTENT) ;
    }
}
