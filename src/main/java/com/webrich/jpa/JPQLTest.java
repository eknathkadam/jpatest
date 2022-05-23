package com.webrich.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPQLTest {

  
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

        for (Employee employee : employeeList) {
			List<EmailGroup> emailGroup = employee.getEmailGroups();
			List<PayStub>stubs = employee.getPayStubs();
			System.out.println(employee);
		}
        
        entityManager.close();
        //entityManagerFactory.close();
    }
}
