package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    public EmployeeRepository employeeRepository ;


    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);

    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id")String id ) throws ResourceNotFoundException {
      Employee employee =  employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
        return  ResponseEntity.ok(employee);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")String id , @RequestBody Employee empDetails) throws ResourceNotFoundException {
        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found"));

        employee.setfName(empDetails.getfName());
        employee.setlName(empDetails.getlName());
        employee.setAddress(empDetails.getAddress());
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable(value="id")String id){
        employeeRepository.deleteById(id);
        return "Employee Deleted";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
       return employeeRepository.findAll();
    }



}
