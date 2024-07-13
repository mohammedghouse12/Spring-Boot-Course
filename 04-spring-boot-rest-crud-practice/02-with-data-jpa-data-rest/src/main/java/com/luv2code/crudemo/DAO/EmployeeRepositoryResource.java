package com.luv2code.crudemo.DAO;

import com.luv2code.crudemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepositoryResource extends JpaRepository<Employee, Integer> {
}
