package com.tw.apistackbase.controller;


import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeRepository repository = new EmployeeRepository();
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return repository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable String employeeId){
        return repository.findById(employeeId);
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delete(@PathVariable String employeeId){
        repository.delete(employeeId);
    }

    @GetMapping("/employees/leastAge/{age}")
    public List<Employee> findEmployeeByAge(@PathVariable int age){
        return repository.findByAge(age);
    }

    @PutMapping("/employees")
    public void update(@RequestBody Employee employee){
        repository.update(employee);
    }

}
