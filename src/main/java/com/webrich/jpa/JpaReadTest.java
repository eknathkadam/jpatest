package com.webrich.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaReadTest {
	public static void main(String[] args) {

		SpringApplication.run(JpaReadTest.class, args);

		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee emp = entityManager.find(Employee.class, 2);

		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Employee found" + emp);

	}

}
