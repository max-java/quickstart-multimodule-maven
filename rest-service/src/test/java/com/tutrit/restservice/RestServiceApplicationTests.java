package com.tutrit.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
public class RestServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Configuration
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(basePackages = "com.tutrit")
    public static class SpringConfig {

    }
}
