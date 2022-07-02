package com.example.employeemanager.services;


import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEMP = employeeRepository.findById(employee.getId()).orElse(null);

        if (existingEMP == null) {
            return employeeRepository.save(employee);
        }else {
            employeeRepository.deleteById(existingEMP.getId());
            employeeRepository.save(employee);
        }
        return employee;
    }

    public boolean deleteEmployeeById(int id){

        try {
            Employee existingEMP = employeeRepository.getById(id);
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception EmptyResultDataAccessException){
            return false;
        }

    }
}
