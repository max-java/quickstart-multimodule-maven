package com.tutrit.persistence.memory.persistence;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.model.EngineerBuilder;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryEngineerPersistence implements EngineerPersistence {
    private final static Map<String, Engineer> engineers = new ConcurrentHashMap<>();

    @Override
    public Engineer save(final Engineer engineer) {
        Engineer persisted = EngineerBuilder
                .builder(engineer)
                .uuid(UUID.randomUUID())
                .build();
        engineers.put(persisted.name(), persisted);
        return persisted;
    }

    @Override
    public Engineer findByName(final String engineerName) {
        return engineers.get(engineerName);
    }
}
