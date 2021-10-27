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
//public class TeacherRestController_getListByDivision {
//    @Autowired
//    private TeacherController teacherController;
//    //test nhap vao gia tri null - LinhDN
//    @Test
//    public void getListByDivision_11(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListByDivision(PageRequest.of(0, 2),null);
//        Assertions.assertEquals(HttpStatus.BAD_REQUEST, pageResponseEntity.getStatusCode());
//
//    }
//
//    //input data tu angular truyen vao se khong vao dc phuong thuc cua spring => khong can test case
////    @Test
////    public void getListByDivision_12(){
////        ResponseEntity<Page<Teacher>> pageResponseEntity
////                = this.teacherController.getTeacherListByDivision(PageRequest.of(0, 2),"abc");
////        Assertions.assertEquals(HttpStatus.BAD_REQUEST, pageResponseEntity.getStatusCode());
////    }
//
//    //test nhap vao gia tri khong hop le - LinhDN
//    @Test
//    public void getListByDivision_13(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListByDivision(PageRequest.of(0, 2),6);
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
//
//    }
//
//    //test nhap vao gia tri hop le - LinhDN
//    @Test
//    public void getListByDivision_14(){
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getTeacherListByDivision(PageRequest.of(0, 2),2);
//        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
//
//        Page<Teacher> teacherPage =pageResponseEntity.getBody();
//        Assertions.assertEquals(1,teacherPage.getTotalElements());
//        Assertions.assertEquals(1,teacherPage.getTotalPages());
//        Assertions.assertEquals("Quế Ngọc Hải",teacherPage.getContent().get(0).getTeacherName());
//    }
//}
