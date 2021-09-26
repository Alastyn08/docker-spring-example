package com.example.dockerspringtest;

import com.example.dockerspringtest.model.Customer;
import com.example.dockerspringtest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class DockerSpringTestApplication {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DockerSpringTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<Customer> allCustomers = this.customerRepository.findAll();
        System.out.println("Number of customers: " + allCustomers);

        Customer newCustomer = new Customer();
        newCustomer.setFirstname("John");
        newCustomer.setLastName("Doe");
        System.out.println("Saving new customer...");
        this.customerRepository.save(newCustomer);

        allCustomers = this.customerRepository.findAll();
        System.out.println("Number of customers: " + allCustomers.size());
    }

}
