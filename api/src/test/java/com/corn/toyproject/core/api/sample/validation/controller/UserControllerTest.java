package com.corn.toyproject.core.api.sample.validation.controller;

import com.corn.toyproject.core.api.sample.validation.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@Slf4j
public class UserControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    @Ignore
    void addUserTest() throws Exception {
        User user = User.builder().name("").age(20).build();
        //log.info("{}", objectMapper.writeValueAsString(user));
        mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)));
    }
}
