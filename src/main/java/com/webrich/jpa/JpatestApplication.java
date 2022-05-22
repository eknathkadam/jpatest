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

		// Employee emp1 = new Employee(1, "eknath", 42, "610553594", new
		// Date(),EmployeeType.CONTRACTOR);

		// Employee emp2 = new Employee(2, "Girish", 28, "610553595",new
		// Date(),EmployeeType.FULL_TIME);
		// Employee emp3 = new Employee(3, "Nirav", 45, "610553596",new
		// Date(),EmployeeType.PAYROLL_EXEMPT);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee emp = entityManager.find(Employee.class, 1);

		EntityTransaction transaction = entityManager.getTransaction();

		// saving/updating the employee objecting
		//emp.setAge(42);

		transaction.begin();

		// saving/updating the employee objecting
		//entityManager.persist(emp);

		entityManager.remove(emp
		);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Employee found" + emp);

	}

}
