package com.tutrit.restservice.client;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EngineerClient {
    @Autowired(required = false)
    private EngineerPersistence engineerPersistence;

    public Engineer save(Engineer engineer) {
        return engineerPersistence.save(engineer);
    }

    public Engineer findByName(String name) {
        return engineerPersistence.findByName(name);
    }
}
