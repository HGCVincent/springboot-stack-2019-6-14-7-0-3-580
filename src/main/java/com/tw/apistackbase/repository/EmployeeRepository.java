package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmployeeRepository {

    private Map<String,Employee> employees = new HashMap<>();

    public EmployeeRepository() {
        employees.put("1111",new Employee("1111","xh",20,"female"));
        employees.put("2222",new Employee("2222","xl",21,"male"));
        employees.put("3333",new Employee("3333","zf",22,"male"));
        employees.put("4444",new Employee("4444","lb",23,"male"));
    }

    public List<Employee> findAll(){
        return employees.values().stream().collect(Collectors.toList());
    }

    public Employee findById(String employeeId){
        return employees.get(employeeId);
    }

    public List<Employee> findByAge(int age) {
        return employees.values().stream().filter(employee -> employee.getAge() > age).collect(Collectors.toList());
    }

    public String save(Employee employee) {
        String employeeId = UUID.randomUUID().toString();
        employees.put(employeeId,employee);
        return employeeId;
    }

    public void delete(String employeeId){
        employees.remove(employeeId);
    }

    public void update(Employee employee) {
        employees.put(employee.getId(),employee);
    }
}
