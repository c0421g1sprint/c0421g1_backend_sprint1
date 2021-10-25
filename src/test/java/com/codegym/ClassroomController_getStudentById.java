package com.codegym;

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
public class ClassroomController_getStudentById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getStudentById_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-student/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-student/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getStudentById_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-student/{id}", "25"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-student/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.studentName").value("Nguyễn Thành Bắc"))
                .andExpect(jsonPath("$.studentDateOfBirth").value("2015-11-11"))
                .andExpect(jsonPath("$.studentGender").value(0))
                .andExpect(jsonPath("$.classroom.classroomId").value(30));
    }
}
