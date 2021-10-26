package com.codegym.controller;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.rest_controller.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentController_findAllClassroom {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StudentController studentController;

    @Test
    public void findAllClassroom_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/get-all-classroom"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllClassroom_6() throws Exception {
        ResponseEntity<List<Classroom>> pageResponseEntity
                = this.studentController.findAllClassroom();
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        List<Classroom> gradeList = pageResponseEntity.getBody();
        Assertions.assertEquals(21, gradeList.size());
        Assertions.assertEquals("3A1", gradeList.get(0).getClassroomName());
        Assertions.assertEquals(1, gradeList.get(0).getClassroomId());
    }
}
