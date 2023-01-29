package com.tutrit.repo.core.persistence;

import com.tutrit.repo.core.bean.Engineer;

public interface EngineerPersistence {
    Engineer save(Engineer engineer);
    Engineer findByName(String engineerName);
}
