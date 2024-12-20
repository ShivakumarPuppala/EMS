package com.crud.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.ems.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

}
