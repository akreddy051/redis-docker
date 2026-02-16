package com.example.test_docker.service;

import com.example.test_docker.entity.Employee;
import com.example.test_docker.repository.EmployeeRepositoryInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    EmployeeRepositoryInterface empRepo;

    @Override
    @Cacheable(value = "employees")
    public List<Employee> getAllEmpService() {
        System.out.println("returning from database");
        return empRepo.findAll();
    }

    @Override
    @Cacheable(value = "employee", key = "#empId")
    public Employee getEmpDetailService(int empId) {
        System.out.println("returning employee from database");
        return empRepo.findById(empId).orElseThrow(()->new RuntimeException("order doesn't exist with order id :"+empId));
    }

    @Override
    @CacheEvict(value = "employees", allEntries = true)
    public String createEmpService(Employee employee) {
        System.out.println("Creating the new employee");
        empRepo.save(employee);
        return "Employee created successfully";
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "employee", key = "#empId"),
            @CacheEvict(value = "employees", allEntries = true)
    })
    public String deleteEmpService(int empId) {
        System.out.println("deleting the employee");
        empRepo.deleteById(empId);
        return "Employee deleted successfully";
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "employee", key = "#empId"),
            @CacheEvict(value = "employees", allEntries = true)
    })
    public String editEmployeeService(Employee employee, int empId) {
        System.out.println("editing the existing employee");
        empRepo.save(employee);
        return "Employee details updated successfully";
    }
}
