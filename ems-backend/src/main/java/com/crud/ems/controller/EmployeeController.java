package com.crud.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.ems.dto.EmployeeDto;
import com.crud.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	 
	 //Build add employee rest API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee=employeeService.createEmployeeDto(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		}
	
	//Build get employee rest API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeeId){
		EmployeeDto employeeDto=employeeService.getEmployeeId(employeeId);
		return ResponseEntity.ok(employeeDto);
		
	}
	//Build get all rest api
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees=employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	//Build updatedemployee rest api
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
	}
	//Build deleteemployee rest api
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted Successfully");
	}

}
