package com.employee_management_system.services;

import java.util.List;
import java.util.UUID;

import com.employee_management_system.dtos.EmployeeCreate;
import com.employee_management_system.dtos.EmployeeUpdate;
import com.employee_management_system.models.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeCreate employeeCreate) ; 
    Employee findEmployeeById (UUID employeeId) ; 
    List<Employee> findALll() ; 
    Employee updateEmployee(EmployeeUpdate employeeUpdate , UUID employeeId) ; 
    void deleteEmployee(UUID employeeId) ; 
}
