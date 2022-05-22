package com.webrich.jpa;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PayStub {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private Date payPeriodStart;
    private Date payPeriodEnd;
    private float salary;

    @ManyToOne 
    private Employee employee;


}
