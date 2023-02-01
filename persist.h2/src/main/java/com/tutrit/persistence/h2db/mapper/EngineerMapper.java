package com.tutrit.persistence.h2db.mapper;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.h2db.entity.EngineerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EngineerMapper {
    Engineer engineerEntityToEngineer(EngineerEntity engineerEntity);
    EngineerEntity engineerToEngineerEntity(Engineer engineer);
}
