package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MarkController_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/marks/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/marks/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.markPointNumber1").value("10.0"))
                .andExpect(jsonPath("$.markPointNumber2").value("10.0"))
                .andExpect(jsonPath("$.markPointNumber3").value("10.0"))
                .andExpect(jsonPath("$.student.studentId").value("1"))
                .andExpect(jsonPath("$.subject.subjectId").value("1"));
    }

}
