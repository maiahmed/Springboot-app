package com.ntg.SpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntg.SpringBootApp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
