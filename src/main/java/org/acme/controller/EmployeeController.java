package org.acme.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.EmployeeDto;
import org.acme.service.EmployeeService;

import java.util.List;

@RequestScoped
@Path("/v1/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GET
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @POST
    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }
}
