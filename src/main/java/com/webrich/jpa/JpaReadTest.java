package com.webrich.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JpaReadTest {
	public static void main(String[] args) {

		SpringApplication.run(JpaReadTest.class, args);

		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//PayStub stub = entityManager.find(PayStub.class, 4);
		//System.out.println(stub.getEmployee());
		 
		// Employee emp = entityManager.find(Employee.class, 2);
		// System.out.println("Employee found" + emp);

        // AccessCard card = entityManager.find(AccessCard.class, 2);
		// System.out.println("AccessCard found" + card);

		EmailGroup group = entityManager.find(EmailGroup.class, 13);
		System.out.println("EmailGroup found" + group);
		System.out.println("******************************************");
		System.out.println("Employees found" + group.getMembers());


		entityManager.close();
		entityManagerFactory.close();


	}

}
