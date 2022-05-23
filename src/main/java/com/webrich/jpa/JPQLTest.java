package com.webrich.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPQLTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e",Employee.class);

        List<Employee> employeeList = query.getResultList();
        System.out.println(employeeList);

        entityManager.close();
        entityManagerFactory.close();

    }
}
