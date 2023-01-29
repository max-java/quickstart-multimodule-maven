package com.tutrit.restservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.repo.core.bean.Engineer;
import com.tutrit.repo.filesystem.persistence.FileSystemEngineerPersistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class EngineerControllerIntTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    FileSystemEngineerPersistence fileSystemEngineerPersistence;

    @Test
    void getByName() throws Exception {
        fileSystemEngineerPersistence.save(makeEngineer());

        final MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/engineers/miKas"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        var actualEngineer = objectMapper.readValue(body, Engineer.class);

        Assertions.assertThat(actualEngineer)
                .usingRecursiveComparison()
                .ignoringFields("uuid")
                .isEqualTo(makeEngineer());
        assertNotNull(actualEngineer.getUuid());
    }

    @Test
    void post() throws Exception {
        final MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/engineers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(makeEngineer())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        var actual = objectMapper.readValue(body, Engineer.class);

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