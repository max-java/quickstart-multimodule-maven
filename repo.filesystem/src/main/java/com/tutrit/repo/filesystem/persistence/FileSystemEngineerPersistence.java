package com.tutrit.repo.filesystem.persistence;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.core.persistence.EngineerPersistence;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FileSystemEngineerPersistence implements EngineerPersistence {
    private final static Map<String, Engineer> engineers = new ConcurrentHashMap<>();

    @Override
    public Engineer save(final Engineer engineer) {
        engineer.setUuid(UUID.randomUUID());
        engineers.put(engineer.getName(), engineer);
        return engineer;
    }

    @Override
    public Engineer findByName(final String engineerName) {
        return engineers.get(engineerName);
    }
}
