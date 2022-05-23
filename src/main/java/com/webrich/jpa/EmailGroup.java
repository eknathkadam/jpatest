package com.webrich.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmailGroup {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ToString.Exclude
    @ManyToMany (mappedBy = "emailGroups" )
    
    private List<Employee> members = new ArrayList<>();

    public void addMember(Employee employee){
        this.members.add(employee);
    }
}
