package com.luv2code.crudemo.Service;

import com.luv2code.crudemo.DAO.EmployeeRepository;
import com.luv2code.crudemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
        }
        else{
            throw new RuntimeException("Employee not found with id - "+ id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
