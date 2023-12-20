package org.acme.mapper;

import org.acme.dao.Employee;
import org.acme.dto.EmployeeDto;

public class EmployeeMapper {
    public static Employee toEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setJobTitle(employeeDto.getJobTitle());
        return employee;
    }

    public static EmployeeDto toDTO(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setJobTitle(employee.getJobTitle());
        return employeeDto;
    }
}
