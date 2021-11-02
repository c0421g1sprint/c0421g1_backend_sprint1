//package com.codegym.controller;
//
//import com.codegym.entity.about_teacher.Teacher;
//import com.codegym.rest_controller.TeacherController;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TeacherRestController_getSearchTeacher {
//    @Autowired
//    private TeacherController teacherController;
//    @Autowired
//    private MockMvc mockMvc;
//    @Test
//    public void getSearchTeacher_7() throws Exception {
//        // 7:tham số search = null
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/{search}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//
//
//    }
//    @Test
//    public void getSearchTeacher_8() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/{search}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//        //8 : tham số search là rỗng
//
//    }
//    @Test
//    public void  getSearchTeacher_9() {
//        ResponseEntity<Page<Teacher>> pageResponseEntity = this.teacherController.getSearchTeacher(PageRequest.of(0,2),"levandiep");
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
//        // 9: tham số không tồn tại
//    }
//    @Test
//    public void  getSearchTeacher_10() {
//        ResponseEntity<Page<Teacher>> pageResponseEntity = this.teacherController.getSearchTeacher(PageRequest.of(0,0),"a");
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
//        // 10: tham số tồn tại và size bằng 0
//    }
//    @Test
//    public void getSearchStudent_11() {
//        ResponseEntity<Page<Teacher>> pageResponseEntity
//                = this.teacherController.getSearchTeacher(PageRequest.of(0, 1),"Tài");
//        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
//
//        Page<Teacher> teacherPage = pageResponseEntity.getBody();
//
//        Assertions.assertEquals(1, teacherPage.getTotalElements());
//        Assertions.assertEquals(1, teacherPage.getTotalPages());
//        Assertions.assertEquals("Tài", teacherPage.getContent().get(0).getTeacherName());
//
//    }
//
//
//}
//
