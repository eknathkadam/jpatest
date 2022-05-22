package com.webrich.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaUpdateTest {

    public static void main(String[] args) {

        SpringApplication.run(JpaUpdateTest.class, args);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 13);

        employee.addEmailSubscription(emailGroup);
        emailGroup.addMember(employee);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(emailGroup);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
