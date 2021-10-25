package com.codegym.controller;

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
public class TeacherRestController_DeleteTeacher {
    @Autowired
    private MockMvc mockMvc;
    //test nhap vao gia tri null - LinhDN
    @Test
    public void DeleteTeacher_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/teachers/delete/{id}",null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test nhap vao gia tri rong - LinhDN
    @Test
    public void DeleteTeacher_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/teachers/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test nhap vao gia tri khong hop le - LinhDN
    @Test
    public void DeleteTeacher_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/teachers/delete/{id}","abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test nhap vao gia tri hop le - LinhDN
    @Test
    public void DeleteTeacher_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/teachers/delete/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
