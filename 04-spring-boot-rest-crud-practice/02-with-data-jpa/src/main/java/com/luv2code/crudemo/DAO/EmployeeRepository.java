package com.luv2code.crudemo.DAO;

import com.luv2code.crudemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
