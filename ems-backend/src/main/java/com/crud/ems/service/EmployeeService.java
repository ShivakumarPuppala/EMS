package com.crud.ems.service;

import java.util.List;

import com.crud.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployeeDto(EmployeeDto employeeDto);
    EmployeeDto getEmployeeId(Long employeeId);
    
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    
    void deleteEmployee(Long employeeId);
}
