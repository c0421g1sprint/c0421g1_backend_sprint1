package com.codegym;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClassroomController_isClassDuplicated {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isClassDuplicated_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-class-room"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void isClassDuplicated_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-class-room?name=&schoolYear="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void isClassDuplicated_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-class-room?name=1A9&schoolYear=2025"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void isClassDuplicated_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/class-room/find-class-room?name=1A1&schoolYear=2019"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.classroomName").value("1A1"))
                .andExpect(jsonPath("$.classroomSchoolYear").value("2019"))
                .andExpect(jsonPath("$.grade.gradeName").value("Khối 1"))
                .andExpect(jsonPath("$.teacher.teacherId").value(1));
    }
}
