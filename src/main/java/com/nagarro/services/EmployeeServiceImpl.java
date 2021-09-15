package com.nagarro.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.entity.Employee;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private  RestTemplate restTemplate;

    public  EmployeeServiceImpl()
    {

        restTemplate=new RestTemplate();
    }

    @Override
    public List<Employee> getEmployeeDetails() {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8082/getEmployeeDetails", Employee[].class);
        return Arrays.asList(response.getBody());
    }
    @Override
    public List<Employee> getEmployeeDetailsById( int employeeCode) {
        ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8082/getEmployeeDetailsById/"+employeeCode, Employee[].class);
        return Arrays.asList(response.getBody());
    }
    @Override
    public void updateEmployeeDetails(Employee employee)
    {
         String uri = "http://localhost:8082/updateEmployeeDetails";
        restTemplate.put(uri, employee);

    }

    @Override
    public void addEmployeeDetails(Employee employee) {
        String uri = "http://localhost:8082/addEmployeeDetails";
        @SuppressWarnings("unused")
		ResponseEntity<Employee> response = restTemplate.postForEntity(uri, employee, Employee.class);
    }


}
