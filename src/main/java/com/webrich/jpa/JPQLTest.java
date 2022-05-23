package com.webrich.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPQLTest {

    // @PersistenceUnit
    // private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;
    public static void main(String[] args) {

        SpringApplication.run(JPQLTest.class, args);

    }

    @PostConstruct
    public void start() {

        // EntityManagerFactory entityManagerFactory =
        // Persistence.createEntityManagerFactory("myApp");
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e", Employee.class);

        List<Employee> employeeList = query.getResultList();
        System.out.println(employeeList);

        //entityManager.close();
        //entityManagerFactory.close();
    }
}
