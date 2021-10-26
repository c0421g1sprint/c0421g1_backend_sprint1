package com.codegym.controller;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.rest_controller.TeacherController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TeacherRestController_getListTeacher {
    @Autowired
    private TeacherController teacherController;

    //test tra ve danh sach rong - 4xxError - LinhDN
    @Test
    public void getListTeacher_1(){
        ResponseEntity<Page<Teacher>> pageResponseEntity
                = this.teacherController.getTeacherList(PageRequest.of(0, 2));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    //test tra ve danh sach  - 2xxOk - LinhDN
    @Test
    public void getListTeacher_2() {
        ResponseEntity<Page<Teacher>> pageResponseEntity
                = this.teacherController.getTeacherList(PageRequest.of(0, 2));
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Teacher> teacherPage =pageResponseEntity.getBody();
        Assertions.assertEquals(5,teacherPage.getTotalElements());
        Assertions.assertEquals(3,teacherPage.getTotalPages());
        Assertions.assertEquals("Bùi Tiến Dũng",teacherPage.getContent().get(0).getTeacherName());
    }

}
