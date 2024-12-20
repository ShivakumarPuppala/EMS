package com.crud.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crud.ems.dto.EmployeeDto;
import com.crud.ems.entity.Employee;
import com.crud.ems.exception.ResourceNotFound;
import com.crud.ems.mapper.EmployeeMapper;
import com.crud.ems.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployeeDto(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return 	EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
	 Employee employee=	employeeRepository.findById(employeeId)
		.orElseThrow(()->new ResourceNotFound("Employee is not exist with given ID:"+employeeId));
		
		                 
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findAll();
		
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFound("employee not exist with this id:"+employeeId));
		    employee.setFirstName(updatedEmployee.getFirstName());
		    employee.setLastName(updatedEmployee.getLastName());
		    employee.setEmail(updatedEmployee.getEmail());
		// TODO Auto-generated method stub
		    Employee updatedEmployeeObj=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFound("employee not exist with this id:"+employeeId));
		employeeRepository.deleteById(employeeId);
		// TODO Auto-generated method stub
		
	}
	
	

}
