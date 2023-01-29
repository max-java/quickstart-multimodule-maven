package com.tutrit.restservice.client;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.core.persistence.EngineerPersistence;
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
        try {
            return engineerPersistence.findByName(name);
        } catch (RuntimeException e) {
            return new Engineer();
        }
    }
}
