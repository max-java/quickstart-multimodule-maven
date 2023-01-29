package com.tutrit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackageClasses = com.tutrit.restservice.RestServiceApplication.class)
public class App
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}


