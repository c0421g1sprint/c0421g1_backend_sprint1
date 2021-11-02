//package com.codegym.controller;
//
//import com.codegym.entity.about_schedule.ScheduleDetail;
//import com.codegym.rest_controller.TeacherController;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class ScheduleDetailController_getScheduleTeacher {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private TeacherController teacherController;
//
//
//    @Test
//    public void showScheduleTailByIdClass_7() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/schedule/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//    @Test
//    public void showScheduleTailByIdClass_8() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/schedule/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void showScheduleTailByIdClass_9() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/schedule/{id}", "15"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void showScheduleTailByIdClass_10() throws Exception{
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/teachers/schedule/{id}", "2"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void showScheduleTailByIdClass_11() {
//        ResponseEntity<List<ScheduleDetail>> listResponseEntity
//                = this.teacherController.showScheduleTeacher(1);
//
//        Assertions.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());
//
//        List<ScheduleDetail> scheduleDetailList = listResponseEntity.getBody();
//
//        Assertions.assertEquals("Lý", scheduleDetailList.get(0).getSubject().getSubjectName());
//    }
//}
