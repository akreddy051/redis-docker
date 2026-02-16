package com.example.test_docker.service;

import com.example.test_docker.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> getAllEmpService();

    Employee getEmpDetailService(int empId);

    String createEmpService(Employee employee);

    String deleteEmpService(int empId);

    String editEmployeeService(Employee employee, int empId);
}
