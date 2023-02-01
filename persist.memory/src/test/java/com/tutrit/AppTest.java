package com.tutrit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads() {
        assertNotNull(ctx);
    }

    @Configuration
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(basePackages = "com.tutrit")
    public static class SpringConfig {

    }
}
