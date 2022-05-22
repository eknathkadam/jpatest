package com.webrich.jpa;

import java.util.Date;

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

		AccessCard card1 = new AccessCard(0, new Date(), true, "1.0.0");
		AccessCard card2 = new AccessCard(0, new Date(), true, "1.0.0");
		AccessCard card3 = new AccessCard(0, new Date(), true, "1.2.0");

		Employee emp1 = new Employee(1, "eknath", 42, "610553594", new
		Date(),EmployeeType.CONTRACTOR,card1);

		Employee emp2 = new Employee(2, "Girish", 28, "610553595",new
		Date(),EmployeeType.FULL_TIME,card2);
		Employee emp3 = new Employee(3, "Nirav", 45, "610553596",new
		Date(),EmployeeType.PAYROLL_EXEMPT,card3);

		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//Employee emp = entityManager.find(Employee.class, 2);

		EntityTransaction transaction = entityManager.getTransaction();

		// saving/updating the employee objecting
		//emp.setAge(42);

		transaction.begin();

		entityManager.persist(card1);
		entityManager.persist(card2);
		entityManager.persist(card3);

		// saving/updating the employee objecting
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);

		//entityManager.remove(emp);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Employee found" + emp1);

	}

}
