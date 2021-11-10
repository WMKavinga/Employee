package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

//model
@Data
@Document
public class Employee {

    @Id
    private Integer id;
    private String fName;
    private String lName;
    private String address;

    public Employee(String fName, String lName, String address) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
    }


//Getters Setters
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
