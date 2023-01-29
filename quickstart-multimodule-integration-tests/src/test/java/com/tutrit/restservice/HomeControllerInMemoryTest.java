package com.tutrit.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutrit.repo.core.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest//(classes=com.tutrit.restservice.RestServiceApplication.class)
@AutoConfigureMockMvc
public class HomeControllerInMemoryTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test

    void homeEndpoint() throws Exception {
        MvcResult mvcResult =
                mockMvc
                        .perform(get("/"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
        assertEquals("InMemory", objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class).getUserName());
    }
}
