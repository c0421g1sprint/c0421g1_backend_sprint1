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
public class StudentController_showDetailStudent {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showDetailStudent_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showDetailStudent_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showDetailStudent_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", "1233"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/detail/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.studentId").value(2))
                .andExpect(jsonPath("$.studentGender").value(0))
                .andExpect(jsonPath("$.studentFatherName").value("Hùng"))
                .andExpect(jsonPath("$.studentMotherName").value("Tuyết"))
                .andExpect(jsonPath("$.studentDateOfBirth").value("1998-02-02"))
                .andExpect(jsonPath("$.studentEthnicity").value("Đà Nẵng"))
                .andExpect(jsonPath("$.studentAddress").value("Đà Nẵng"))
                .andExpect(jsonPath("$.studentName").value("An"))
                .andExpect(jsonPath("$.studentReligion").value("Việt nam"))
                .andExpect(jsonPath("$.studentStatus").value("Đã tốt nghiệp"))
                .andExpect(jsonPath("$.studentParentPhone").value("08083508"))
                .andExpect(jsonPath("$.deleteFlag").value(false));
    }

}
