package com.employee_management_system.models;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employee") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID") 
    @UuidGenerator
    private UUID id ; 

    @Column(name = "first_name" , nullable = false , length = 50) 
    private String firstName ; 


    @Column(name = "last_name" , nullable = false , length = 50) 
    private String lastName ; 

    @Column(name = "email" , nullable = false , unique = true) 
    private String email ; 


    @Column(name = "phone_number" , length = 11) 
    private String phoneNumber ; 

    @Column(name = "hire_Date" , nullable = false)
    private LocalDate hireDate ; 

    @Column(name = "position" , nullable = false)
    private String position ; 
    
    private UUID departmentId ; 

}
