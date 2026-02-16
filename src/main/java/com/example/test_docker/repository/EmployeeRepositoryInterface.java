package com.example.test_docker.repository;

import com.example.test_docker.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryInterface extends JpaRepository<Employee,Integer> {
}
