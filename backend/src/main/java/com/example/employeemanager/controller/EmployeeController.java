package com.example.employeemanager.controller;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Add
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    //Add more than one
    @PostMapping("/addEmployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }

    //Get all
    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    //Get employee by Id
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    //Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public Employee getEmployee(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    //Update employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    //Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public Boolean deleteEmployeeById(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
