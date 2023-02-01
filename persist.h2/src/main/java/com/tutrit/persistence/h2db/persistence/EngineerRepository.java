package com.tutrit.persistence.h2db.persistence;

import com.tutrit.persistence.h2db.entity.EngineerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EngineerRepository extends CrudRepository<EngineerEntity, UUID> {
    Optional<EngineerEntity> findByName(String name);
}
