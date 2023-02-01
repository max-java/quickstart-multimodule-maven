package com.tutrit.persistence.h2db.persistence;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import com.tutrit.persistence.h2db.entity.EngineerEntity;
import com.tutrit.persistence.h2db.mapper.EngineerMapper;
import org.springframework.stereotype.Component;

@Component
public class EngineerDBPersistenceService implements EngineerPersistence {
    private final EngineerRepository engineerRepository;
    private final EngineerMapper engineerMapper;

    public EngineerDBPersistenceService(final EngineerRepository engineerRepository,
                                        final EngineerMapper engineerMapper) {
        this.engineerRepository = engineerRepository;
        this.engineerMapper = engineerMapper;
    }

    @Override
    public Engineer save(final Engineer engineer) {
        EngineerEntity engineerEntity = engineerMapper.engineerToEngineerEntity(engineer);
        return engineerMapper.engineerEntityToEngineer(engineerRepository.save(engineerEntity));
    }

    @Override
    public Engineer findByName(final String engineerName) {
        EngineerEntity engineerEntity = engineerRepository.findByName(engineerName).orElse(null);
        return engineerMapper.engineerEntityToEngineer(engineerEntity);
    }
}
