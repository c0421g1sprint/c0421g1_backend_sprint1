package com.codegym.controller;


import com.codegym.entity.about_student.Student;
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

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_getInfoStudent {


    @Autowired
    private StudentController studentController;


    @Test
    public void showListStudentByIdTeacher_5() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentController.showListStudentByIdTeacher(PageRequest.of(0, 2), 1);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void showListStudentByIdTeacher_6() {
        ResponseEntity<Page<Student>> pageResponseEntity
                = this.studentController.showListStudentByIdTeacher(PageRequest.of(0, 2), 1);

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Student> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(5, studentPage.getTotalElements());
        Assertions.assertEquals(3, studentPage.getTotalPages());
        Assertions.assertEquals("ATai", studentPage.getContent().get(1).getStudentName());
    }


}
