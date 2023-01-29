package com.tutrit.repo.filesystem.persistence;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.core.persistence.EngineerPersistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileSystemEngineerPersistenceTest {

    private EngineerPersistence persistence;

    @BeforeEach
    public void setUp() {
        persistence = new FileSystemEngineerPersistence();
    }

    @Test
    void save() {
        var actual = persistence.save(makeEngineer());
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(makeEngineer());
        assertNotNull(actual.getUuid());
    }

    @Test
    void findByName() {
        persistence.save(makeEngineer());
        var actual = persistence.findByName("MIKAS");
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(makeEngineer());
        assertNotNull(actual.getUuid());
    }

    private Engineer makeEngineer() {
        var engineer = new Engineer();
        engineer.setName("MIKAS");
        return engineer;
    }
}