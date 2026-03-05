package com.employee_management_system.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeUpdate(

    @NotNull(message = "First Name is required") 
    @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String firstName , 

    @NotNull(message = "Last Name is required") 
     @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String lastName , 



    @NotNull(message = "Position Name is required") 
    @Size(min = 2 , max = 50 , message = "min is 2 charachter and max is 50")
    String position , 
    

    @NotNull(message = "Phone number is required")
    @Pattern(
        regexp = "^\\+?[0-9]{10,15}$" , 
        message = "Invailed phone number format"
    )
    String phoneNumber  

) {

}
