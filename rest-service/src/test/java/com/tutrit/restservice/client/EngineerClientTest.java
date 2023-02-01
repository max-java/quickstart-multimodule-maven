package com.tutrit.restservice.client;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static com.tutrit.restservice.RestServiceApplicationTests.SpringConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringConfig.class)
class EngineerClientTest {

    @Autowired
    EngineerClient engineerClient;

    @MockBean
    EngineerPersistence engineerPersistence;

    @Test
    void save() {
        when(engineerPersistence.save(makeVictim())).thenReturn(makeExpected());
        var actualEngineer = engineerClient.save(makeVictim());
        assertEquals(makeExpected(), actualEngineer);
    }

    @Test
    void findByName() {
        when(engineerPersistence.findByName("MIKAS")).thenReturn(makeExpected());
        var actualEngineer = engineerClient.findByName("MIKAS");
        assertEquals(makeExpected(), actualEngineer);
    }

    private Engineer makeVictim() {
        return new Engineer(null, "miKas");
    }

    private Engineer makeExpected() {
        return new Engineer(UUID.fromString("e4d18f81-5d19-4b19-90c4-8a2737244915"), "MIKAS");
    }
}