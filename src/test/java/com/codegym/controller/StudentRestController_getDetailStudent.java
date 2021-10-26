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
public class StudentRestController_getDetailStudent {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getListStudentDetail_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudentDetail_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudentDetail_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", "6"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getListStudentDetail_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/list/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.studentName").value("Nhật"))
                .andExpect(jsonPath("$.studentDateOfBirth").value("2000-07-14"));
    }
}
