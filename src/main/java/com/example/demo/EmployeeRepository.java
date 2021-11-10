package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
//Repo Class
@Component
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
