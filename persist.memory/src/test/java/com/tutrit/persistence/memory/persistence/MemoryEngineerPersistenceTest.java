package com.tutrit.persistence.memory.persistence;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryEngineerPersistenceTest {

    private EngineerPersistence persistence;

    @BeforeEach
    public void setUp() {
        persistence = new MemoryEngineerPersistence();
    }

    @Test
    void save() {
        var actual = persistence.save(makeEngineer());
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(makeEngineer());
        assertNotNull(actual.uuid());
    }

    @Test
    void findByName() {
        persistence.save(makeEngineer());
        var actual = persistence.findByName("MIKAS");
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(makeEngineer());
        assertNotNull(actual.uuid());
    }

    private Engineer makeEngineer() {
        return new Engineer(null, "MIKAS");
    }
}