package com.tutrit.persistence.h2db.persistence;

import com.tutrit.AppTest;
import com.tutrit.persistence.core.model.Engineer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AppTest.SpringConfig.class)
public class EngineerDBPersistenceServiceTest {

    @Autowired
    private EngineerDBPersistenceService persistence;


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
        var engineer = new Engineer(null, "MIKAS");
        return engineer;
    }
}