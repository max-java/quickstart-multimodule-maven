package com.tutrit.restservice.client;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.core.persistence.EngineerPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
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
        var engineer = new Engineer();
        engineer.setName("MIKAS");
        return engineer;
    }

    private Engineer makeExpected() {
        var engineer = new Engineer();
        engineer.setName("MIKAS");
        engineer.setUuid(UUID.fromString("e4d18f81-5d19-4b19-90c4-8a2737244915"));
        return engineer;
    }
}