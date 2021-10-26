package com.codegym.controller;

import com.codegym.dto.StudentDTO;
import com.codegym.rest_controller.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentController_getStudentsOfClassroom {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentController studentController;

    @Test
    public void getStudentsOfClassroom_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentsOfClassroom_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentsOfClassroom_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/{id}", "7749"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentsOfClassroom_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/{id}", "4"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentsOfClassroom_11() {
        ResponseEntity<Page<StudentDTO>> pageResponseEntity
                = this.studentController.getStudentsOfClassroom("1", PageRequest.of(0, 10));
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<StudentDTO> studentPage = pageResponseEntity.getBody();
        System.out.println(studentPage.getContent().get(6));
        Assertions.assertEquals(7, studentPage.getTotalElements());
        Assertions.assertEquals(1, studentPage.getTotalPages());
        Assertions.assertEquals("Trương Vô Kỵ", studentPage.getContent().get(6).getStudentName());
        Assertions.assertEquals(13, studentPage.getContent().get(6).getStudentId());
        Assertions.assertEquals("2015-09-28", studentPage.getContent().get(6).getStudentDateOfBirth());
    }
}