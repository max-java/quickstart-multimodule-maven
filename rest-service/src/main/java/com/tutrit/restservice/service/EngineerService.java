package com.tutrit.restservice.service;

import com.tutrit.repo.core.bean.Engineer;
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
        engineer.setName(engineer.getName().toUpperCase(Locale.ROOT));
        return engineerClient.save(engineer);
    }

    public Engineer findByName(String name) {
        return engineerClient.findByName(name.toUpperCase(Locale.ROOT));
    }
}
