package com.webrich.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWriteTest {

	public static void main(String[] args) {

		SpringApplication.run(JpaWriteTest.class, args);

		AccessCard card1 = new AccessCard(0, new Date(), true, "1.0.0", null);
		AccessCard card2 = new AccessCard(0, new Date(), true, "1.0.0", null);
		AccessCard card3 = new AccessCard(0, new Date(), true, "1.2.0", null);

		Employee emp1 = new Employee(1, "eknath", 42, "610553594", new Date(), EmployeeType.CONTRACTOR, card1,null);

		Employee emp2 = new Employee(2, "Girish", 28, "610553595", new Date(), EmployeeType.FULL_TIME, card2,null);
		Employee emp3 = new Employee(3, "Nirav", 45, "610553596", new Date(), EmployeeType.PAYROLL_EXEMPT, card3,null);

		card1.setOwner(emp1);
		card2.setOwner(emp2);
		card3.setOwner(emp3);

		PayStub stub1 = new PayStub(0, new Date(), new Date(), 1000,emp1);
		PayStub stub2 = new PayStub(0, new Date(), new Date(), 1500,emp1);
		PayStub stub3 = new PayStub(0, new Date(), new Date(), 2000,emp1);

		PayStub stub4 = new PayStub(0, new Date(), new Date(), 1000,emp2);
		PayStub stub6 = new PayStub(0, new Date(), new Date(), 1500,emp2);
		PayStub stub5 = new PayStub(0, new Date(), new Date(), 2000,emp2);

		PayStub stub7 = new PayStub(0, new Date(), new Date(), 1000,emp3);
		PayStub stub8 = new PayStub(0, new Date(), new Date(), 1500,emp3);
		PayStub stub9 = new PayStub(0, new Date(), new Date(), 2000,emp3);

		emp1.setPayStubs(List.of(stub1,stub2,stub3));
		emp2.setPayStubs(List.of(stub4,stub5,stub6));
		emp3.setPayStubs(List.of(stub7,stub8,stub9));

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		 entityManager.persist(card1);
		 entityManager.persist(card2);
		 entityManager.persist(card3);

		// saving/updating the employee objecting
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);

		entityManager.persist(stub1);
		entityManager.persist(stub2);
		entityManager.persist(stub3);
		entityManager.persist(stub4);
		entityManager.persist(stub5);
		entityManager.persist(stub6);
		entityManager.persist(stub7);
		entityManager.persist(stub8);
		entityManager.persist(stub9);

		// entityManager.remove(emp);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();

		// System.out.println("Employee found" + emp1);

	}

}
