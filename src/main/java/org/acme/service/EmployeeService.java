package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.EmployeeDto;
import org.acme.mapper.EmployeeMapper;
import org.acme.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        return EmployeeMapper.toDTO(
                employeeRepository.save(EmployeeMapper.toEntity(employeeDto))
        );
    }
}
