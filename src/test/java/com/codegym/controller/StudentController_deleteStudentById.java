package com.codegym.controller;

import com.codegym.rest_controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentController_deleteStudentById {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentController studentController;

    @Test
    public void deleteStudentById_19() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/students/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteStudentById_20() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/students/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteStudentById_21() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/students/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteStudentById_24() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/students/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}