package com.nagarro.services;

import java.util.List;

import com.nagarro.entity.Employee;

public interface EmployeeService {

 List<Employee> getEmployeeDetails();
 void updateEmployeeDetails(Employee employee);
 void addEmployeeDetails(Employee employee);
 List<Employee> getEmployeeDetailsById(int employeeCode);
}
