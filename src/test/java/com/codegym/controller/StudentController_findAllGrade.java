package com.codegym.controller;

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
public class StudentController_findAllGrade {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StudentController studentController;

    @Test
    public void findAllGrade_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/students/get-all-grade"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllGrade_6() throws Exception {
        ResponseEntity<List<Grade>> pageResponseEntity
                = this.studentController.findAllGrade();
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        List<Grade> gradeList = pageResponseEntity.getBody();
        Assertions.assertEquals(5, gradeList.size());
        Assertions.assertEquals("Khối 1", gradeList.get(0).getGradeName());
        Assertions.assertEquals(1, gradeList.get(0).getGradeId());
    }
}
