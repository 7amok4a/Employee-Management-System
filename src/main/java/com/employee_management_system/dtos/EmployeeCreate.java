package com.employee_management_system.dtos;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeCreate(

    @NotNull(message = "First Name is required") 
    @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String firstName , 

    @NotNull(message = "Last Name is required") 
     @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String lastName , 


    @NotNull(message = "Email is required")
    @Pattern(
        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , 
        message = "invailid Email"
    )
    String email , 



    @NotNull(message = "Position Name is required") 
    @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String position , 
    
    @NotNull(message = "Hire date is required")
    @PastOrPresent(message = "Hire data can't be in the future")
    LocalDate hireDate , 

    @NotNull(message = "Phone number is required")
    // @Pattern(
    //     regexp = "^\\+?[0-9]{10,15}$" , 
    //     message = "Invailed phone number format"
    // )
    @Email(message = "Invailed Email")
    String phoneNumber  , 


    @NotNull(message = "Department Id is required")
    UUID departmentId

) {

}
