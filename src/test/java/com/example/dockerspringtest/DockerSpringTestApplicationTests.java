package com.example.dockerspringtest;

import com.example.dockerspringtest.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class DockerSpringTestApplicationTests {

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

}
