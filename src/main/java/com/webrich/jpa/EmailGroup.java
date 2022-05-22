package com.webrich.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @ManyToMany
    @JoinTable(name = "Email_Group_Subscriptions",
    joinColumns = @JoinColumn(name="group_id"),
     inverseJoinColumns = @JoinColumn(name="employee_id")
     )
    private List<Employee> members;

}
