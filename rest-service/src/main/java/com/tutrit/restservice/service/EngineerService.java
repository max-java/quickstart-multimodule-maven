package com.tutrit.restservice.service;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.model.EngineerBuilder;
import com.tutrit.restservice.client.EngineerClient;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class EngineerService {

    private final EngineerClient engineerClient;

    public EngineerService(final EngineerClient engineerClient) {
        this.engineerClient = engineerClient;
    }

    public Engineer save(Engineer engineer) {
        Engineer uppercaseEngineer = EngineerBuilder.from(engineer).withName(engineer.name().toUpperCase(Locale.ROOT));
        return engineerClient.save(uppercaseEngineer);
    }

    public Engineer findByName(String name) {
        return engineerClient.findByName(name.toUpperCase(Locale.ROOT));
    }
}
