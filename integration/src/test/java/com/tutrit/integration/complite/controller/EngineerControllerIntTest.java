package com.tutrit.integration.complite.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.persistence.core.model.Engineer;;
import com.tutrit.persistence.core.persistence.EngineerPersistence;
import com.tutrtit.Application;
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

@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
class EngineerControllerIntTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    EngineerPersistence fileSystemEngineerPersistence;

    @Test
    void getByName() throws Exception {
        // before test
        if (fileSystemEngineerPersistence.findByName(makeEngineer().name()) == null) {
            fileSystemEngineerPersistence.save(makeEngineer());
        }

        // test
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
        assertNotNull(actualEngineer.uuid());
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
        assertNotNull(actual.uuid());
    }

    private Engineer makeEngineer() {
        return new Engineer(null, "MIKAS");
    }
}