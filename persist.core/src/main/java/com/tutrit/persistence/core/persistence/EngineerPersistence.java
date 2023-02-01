package com.tutrit.persistence.core.persistence;

import com.tutrit.persistence.core.model.Engineer;

public interface EngineerPersistence {
    Engineer save(Engineer engineer);
    Engineer findByName(String engineerName);
}
