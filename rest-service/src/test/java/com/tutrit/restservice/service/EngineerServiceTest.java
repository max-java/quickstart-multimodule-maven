package com.tutrit.restservice.service;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.restservice.RestServiceApplicationTests.SpringConfig;
import com.tutrit.restservice.client.EngineerClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringConfig.class)
class EngineerServiceTest {

    @Autowired
    EngineerService engineerService;

    @MockBean
    EngineerClient engineerClient;

    @Test
    void save() {
        var engineer = makeVictim();

        when(engineerClient.save(makeVictimBeforeSaving())).thenReturn(makeExpected());

        var actualEngineer = engineerService.save(engineer);

        assertEquals(makeExpected(), actualEngineer);
    }

    @Test
    void findByName() {
        when(engineerClient.findByName("MIKAS")).thenReturn(makeExpected());

        var actualEngineer = engineerService.findByName("miKas");

        assertEquals(makeExpected(), actualEngineer);
    }

    private Engineer makeVictim() {
        return new Engineer(null, "miKas");
    }

    private Engineer makeVictimBeforeSaving() {
        return new Engineer(null, "MIKAS");
    }

    private Engineer makeExpected() {
        return new Engineer(UUID.fromString("e4d18f81-5d19-4b19-90c4-8a2737244915"), "MIKAS");
    }
}