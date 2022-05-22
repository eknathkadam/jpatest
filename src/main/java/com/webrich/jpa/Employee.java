package com.webrich.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @Temporal(TemporalType.TIME)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne
    private AccessCard card;
}
