package com.codegym;

import com.codegym.entity.about_teacher.Teacher;
import com.codegym.rest_controller.ClassRoomController;
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
public class ClassroomController_getListTeacherNotHaveChairedClass {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClassRoomController classRoomController;

    @Test
    public void getListTeacherNotHaveChairedClass_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-teacher"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getListTeacherNotHaveChairedClass_6() throws Exception {

        ResponseEntity<List<Teacher>> responseEntity
                = this.classRoomController.getListTeacherNotHaveChairedClass();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Teacher> teacherList = responseEntity.getBody();

        Assertions.assertEquals(4, teacherList.size());
        Assertions.assertEquals("Trấn Thành", teacherList.get(0).getTeacherName());
    }
}
