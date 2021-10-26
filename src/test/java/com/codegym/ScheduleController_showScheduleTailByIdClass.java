package com.codegym;



import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.ScheduleDetail;
import com.codegym.rest_controller.ScheduleController;
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

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleController_showScheduleTailByIdClass {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ScheduleController scheduleController;

    @Test
    public void showScheduleTailByIdClass_7() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/schedules/schedule-detail/{classId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void showScheduleTailByIdClass_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/schedules/schedule-detail/{classId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void showScheduleTailByIdClass_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/schedules/schedule-detail/{classId}", "15"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void showScheduleTailByIdClass_10() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/schedules/schedule-detail/{classId}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void showScheduleTailByIdClass_11() {
        ResponseEntity<List<ScheduleDetail>> listResponseEntity
                = this.scheduleController.showScheduleTailByIdClass(java.util.Optional.of("1"));

        Assertions.assertEquals(HttpStatus.OK, listResponseEntity.getStatusCode());

        List<ScheduleDetail> scheduleDetailList = listResponseEntity.getBody();

        Assertions.assertEquals("Toán", scheduleDetailList.get(0).getSubject().getSubjectName());
    }

    @Test
    public void showListClass_5() {
        ResponseEntity<List<Classroom>> pageResponseEntity
                = this.scheduleController.showListClass();
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void showListClass_6() {
        ResponseEntity<List<Classroom>> pageResponseEntity
                = this.scheduleController.showListClass();
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        List<Classroom> classrooms = pageResponseEntity.getBody();

        Assertions.assertEquals("1A1", classrooms.get(1).getClassroomName());
    }

    @Test
    public void showListGrade_5() {
        ResponseEntity<List<Grade>> pageResponseEntity
                = this.scheduleController.showListGrade();
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void showListGrade_6() {
        ResponseEntity<List<Grade>> pageResponseEntity
                = this.scheduleController.showListGrade();
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        List<Grade> grades = pageResponseEntity.getBody();

        Assertions.assertEquals("Khối 2", grades.get(1).getGradeName());
    }
}
