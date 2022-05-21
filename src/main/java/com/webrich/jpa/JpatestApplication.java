package com.webrich.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpatestApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(JpatestApplication.class, args);

		Employee emp1 = new Employee(1, "Eknath");
		Employee emp2 = new Employee(2, "Nirav");

		Employee emp3 = new Employee(3, "Girish");


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();




		transaction.begin();

		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		
		transaction.commit();

		System.out.println("Transaction commited");



	}

	

}
