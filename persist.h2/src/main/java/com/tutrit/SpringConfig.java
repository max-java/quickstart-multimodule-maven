package com.tutrit;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.tutrit")
@EnableJpaRepositories(basePackages = "com.tutrit")
public class SpringConfig {}
