package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		
		// save a couple of customers
		repository.save(new Customer("Zeeshan", "Ahmed Khan"));
		repository.save(new Customer("Faizan", "Ahmed Khan"));
		
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
		
		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Zeeshan'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Zeeshan"));

		System.out.println("Customers found with findByLastName('Faizan'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Faizan")) {
			System.out.println(customer);
		}
	}

}
