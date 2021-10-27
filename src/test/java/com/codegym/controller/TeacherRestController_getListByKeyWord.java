//package com.codegym.controller;
//
//import com.codegym.entity.about_teacher.Teacher;
//import com.codegym.rest_controller.TeacherController;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//class TeacherRestController_getListByKeyWord {
//    @Autowired
//    private TeacherController teacherController;
//    @Test
//    public void getListByKeyWord_3(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListWithKeyWord(PageRequest.of(0, 2),null);
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
//
//    }
//
//    @Test
//    public void getListByKeyWord_4(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListWithKeyWord(PageRequest.of(0, 2),"");
//        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
//
//        Page<Teacher> teacherPage =pageResponseEntity.getBody();
//        Assertions.assertEquals(5,teacherPage.getTotalElements());
//        Assertions.assertEquals(3,teacherPage.getTotalPages());
//        Assertions.assertEquals("Bùi Tiến Dũng",teacherPage.getContent().get(0).getTeacherName());
//    }
//
//    @Test
//    public void getListByKeyWord_5(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListWithKeyWord(PageRequest.of(0, 2),"ert4");
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
//    }
//
//    @Test
//    public void getListByKeyWord_6(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListWithKeyWord(PageRequest.of(0, 2),"ng");
//        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
//
//        Page<Teacher> teacherPage =pageResponseEntity.getBody();
//        Assertions.assertEquals(3,teacherPage.getTotalElements());
//        Assertions.assertEquals(2,teacherPage.getTotalPages());
//        Assertions.assertEquals("Bùi Tiến Dũng",teacherPage.getContent().get(0).getTeacherName());
//    }
//}
