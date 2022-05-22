package com.webrich.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @AllArgsConstructor @NoArgsConstructor

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

    @OneToOne //(fetch = FetchType.LAZY)
    private AccessCard card;

    @OneToMany (mappedBy = "employee", cascade = CascadeType.REMOVE)
   // @JoinColumn (name = "paystub_for")
    private List<PayStub> payStubs;

    @ManyToMany 
    @JoinTable(name = "Email_Group_Subscriptions",
    joinColumns = @JoinColumn(name="employee_id"),
     inverseJoinColumns = @JoinColumn(name="group_id")
     )
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public void addEmailSubscription(EmailGroup group){
        this.emailGroups.add(group);
    }

    public Employee addPayStub(PayStub stub){
        this.payStubs.add(stub);
        return this;
    }

    

}
