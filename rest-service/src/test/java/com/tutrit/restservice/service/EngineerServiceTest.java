package com.tutrit.restservice.service;

import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.restservice.client.EngineerClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
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
        var engineer = new Engineer();
        engineer.setName("mikas");
        return engineer;
    }

    private Engineer makeVictimBeforeSaving() {
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