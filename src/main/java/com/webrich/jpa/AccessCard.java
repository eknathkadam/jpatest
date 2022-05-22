package com.webrich.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class AccessCard {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;
    
    @ToString.Exclude
    @OneToOne  (mappedBy = "card")
    private Employee owner;
}
