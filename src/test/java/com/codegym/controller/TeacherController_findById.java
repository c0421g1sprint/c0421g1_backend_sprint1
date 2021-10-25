package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherController_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/accountId", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.teacherName").value("Bùi Tiến Dũng"))
                .andExpect(jsonPath("$.teacherAddress").value("Bach Dang - Hải Châu - Đà Nẵng"))
                .andExpect(jsonPath("$.teacherDateOfBirth").value("1988-11-11"))
                .andExpect(jsonPath("$.teacherEmail").value("dung@gmail.com"))
                .andExpect(jsonPath("$.teacherGender").value(0))
                .andExpect(jsonPath("$.teacherImage").value("https://toplist.vn/images/800px/studio-huu-tri-317829.jpg"))
                .andExpect(jsonPath("$.teacherPhone").value("0810000009"))
                .andExpect(jsonPath("$.teacherUniversity").value("Đại học Sư phạm Đà Nẵng"))
                .andExpect(jsonPath("$.degree.degreeId").value(1))
                .andExpect(jsonPath("$.deleteFlag").value(false))
                .andExpect(jsonPath("$.division.divisionId").value(1))
                .andExpect(jsonPath("$.account.accountId").value(1));
    }
}
