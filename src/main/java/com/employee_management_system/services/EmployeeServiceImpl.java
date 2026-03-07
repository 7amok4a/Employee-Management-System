package com.employee_management_system.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.dtos.EmployeeCreate;
import com.employee_management_system.dtos.EmployeeUpdate;
import com.employee_management_system.models.Employee;
import com.employee_management_system.repositories.EmployeeRepository;
import com.employee_management_system.shared.CustomResponseException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository ;
    @Override
    public Employee createEmployee(EmployeeCreate employeeCreate) {
        Employee employee = new Employee() ; 
        employee.setFirstName(employeeCreate.firstName());
        employee.setLastName(employeeCreate.lastName()); 
        employee.setEmail(employeeCreate.email()); 
        employee.setHireDate(employeeCreate.hireDate()); 
        employee.setPosition(employeeCreate.position()); 
        employee.setPhoneNumber(employeeCreate.phoneNumber()); 

        employeeRepository.save(employee) ; 
        return employee ; 
    }

    @Override
    public Employee findEmployeeById(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                CustomResponseException.ResourceNotFound("Employee with id" + employeeId + " is not found")            

            ) ; 

        return employee ; 
    }

    @Override
    public List<Employee> findALll() {
      List<Employee> employees = employeeRepository.findAll() ; 

      return employees ; 
    }

    @Override
    public Employee updateEmployee(EmployeeUpdate employeeUpdate, UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                CustomResponseException.ResourceNotFound("Employee with id" + employeeId + " is not found") 
            ) ; 

        employee.setFirstName(employeeUpdate.firstName());
        employee.setLastName(employeeUpdate.lastName()); 
        employee.setPosition(employeeUpdate.position());
        employee.setPhoneNumber(employeeUpdate.phoneNumber());
        
        employeeRepository.save(employee) ; 
        return employee ; 
    }

    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() ->
                CustomResponseException.ResourceNotFound("Employee with id : " + employeeId + " is not found")
            ) ; 

        employeeRepository.delete(employee); 


    }

}
