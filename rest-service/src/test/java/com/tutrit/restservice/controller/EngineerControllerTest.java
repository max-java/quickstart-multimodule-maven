package com.tutrit.restservice.controller;

import com.tutrit.persistence.core.model.Engineer;
import com.tutrit.restservice.RestServiceApplicationTests.SpringConfig;
import com.tutrit.restservice.service.EngineerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringConfig.class)
class EngineerControllerTest {

    @Autowired
    EngineerController engineerController;

    @MockBean
    EngineerService engineerService;

    @Test
    void getByName() {
        when(engineerService.findByName("miKas")).thenReturn(makeExpected());
        Engineer actualEngineer = engineerController.getByName("miKas");
        assertEquals(makeExpected(), actualEngineer);
    }

    @Test
    void post() {
        when(engineerService.save(makeVictim())).thenReturn(makeExpected());
        Engineer actualEngineer = engineerController.post(makeVictim());
        assertEquals(makeExpected(), actualEngineer);
    }


    private Engineer makeVictim() {
        return new Engineer(null, "miKas");
    }

    private Engineer makeExpected() {
        return new Engineer(UUID.fromString("e4d18f81-5d19-4b19-90c4-8a2737244915"), "MIKAS");
    }
}