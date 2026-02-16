package com.example.test_docker.controller;

import com.example.test_docker.entity.Employee;
import com.example.test_docker.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceInterface employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmpService();
    }

    @GetMapping("/{empId}")
    public Employee getAllEmployees(@PathVariable("empId") int empId) {
        return employeeService.getEmpDetailService(empId);
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee){
        System.out.println("sadfjbkasjd");
        return employeeService.createEmpService(employee);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable("empId") int empId){
        return employeeService.deleteEmpService(empId);
    }

    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable("empId") int empId,@RequestBody Employee employee){
        return employeeService.editEmployeeService(employee,empId);
    }
}
