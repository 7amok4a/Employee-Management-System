package com.employee_management_system.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_management_system.models.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository <Employee , UUID>{

}
