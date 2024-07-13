package com.luv2code.crudemo.Service;

import com.luv2code.crudemo.Entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);
}
