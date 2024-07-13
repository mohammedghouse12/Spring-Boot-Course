package com.luv2code.crudemo.DAO;

import com.luv2code.crudemo.Entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    String deleteById(int id);
}
