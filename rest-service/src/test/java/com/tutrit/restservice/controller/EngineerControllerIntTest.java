package com.tutrit.restservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.core.persistence.EngineerPersistence;
import com.tutrit.restservice.client.EngineerClient;
import com.tutrit.restservice.service.EngineerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class EngineerControllerIntTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @SpyBean
    EngineerService engineerService;
    @SpyBean
    EngineerClient engineerClient;
    @MockBean
    EngineerPersistence engineerPersistence;

    @Test
    void getByName() throws Exception {
        when(engineerPersistence.findByName("MIKAS")).thenReturn(makeExpected());

        final MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/engineers/miKas"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        var actualEngineer = objectMapper.readValue(body, Engineer.class);

        assertEquals(makeExpected(), actualEngineer);
        Mockito.verify(engineerService).findByName("miKas");
        Mockito.verify(engineerClient).findByName("MIKAS");
        Mockito.verify(engineerPersistence).findByName("MIKAS");
    }

    @Test
    void post() throws Exception {
        when(engineerPersistence.save(makeVictimBeforeSaving())).thenReturn(makeExpected());

        final MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/engineers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(makeVictim())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        var actualEngineer = objectMapper.readValue(body, Engineer.class);

        assertEquals(makeExpected(), actualEngineer);
        Mockito.verify(engineerService, times(1)).save(any());
        Mockito.verify(engineerClient, times(1)).save(any());
        Mockito.verify(engineerPersistence, times(1)).save(any());
    }

    private Engineer makeVictim() {
        var engineer = new Engineer();
        engineer.setName("miKas");
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