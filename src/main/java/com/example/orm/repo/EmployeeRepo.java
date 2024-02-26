package com.example.orm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
