package com.example.dockerspringtest.controller;

import com.example.dockerspringtest.model.Customer;
import com.example.dockerspringtest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/api/customers/count")
    public String sayHello() {
        List<Customer> allCustomers = this.customerRepository.findAll();
        return "Number of customers: " + allCustomers.size();
    }
}
