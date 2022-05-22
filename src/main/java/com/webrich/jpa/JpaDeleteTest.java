package com.webrich.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDeleteTest {

    public static void main(String[] args) {

        SpringApplication.run(JpaDeleteTest.class, args);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
