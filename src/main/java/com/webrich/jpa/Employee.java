package com.webrich.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

//@Table(name="EMPLOYEE_DATA", schema = "", catalog = "")
public class Employee {    
    @Id
    private int id;
    private String name; 
    private int age;
    @Column(unique = true, length = 10, nullable=false)
    private String ssn;
}
