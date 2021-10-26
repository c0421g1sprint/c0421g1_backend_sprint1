package com.codegym.controller;


import com.codegym.entity.about_student.Student;
import com.codegym.rest_controller.StudentController;
import com.codegym.rest_controller.TeacherController;
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
public class StudentRestController_getInfoStudent {

    @Autowired
    private TeacherController teacherController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void showListStudentByIdTeacher_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/list/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListStudentByIdTeacher_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/list/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListStudentByIdTeacher_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/list/{id}", "19"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListStudentByIdTeacher_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/teachers/list/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListStudentByIdTeacher_11() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.teacherController.showListStudentByIdTeacher(PageRequest.of(0, 2), java.util.Optional.of(1));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(2, studentPage.getTotalElements());
        Assertions.assertEquals(1, studentPage.getTotalPages());
        Assertions.assertEquals("Hai", studentPage.getContent().get(1).getStudentName());
    }


}
