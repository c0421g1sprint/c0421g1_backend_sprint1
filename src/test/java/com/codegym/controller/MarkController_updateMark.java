//package com.codegym.controller;
//
//import com.codegym.dto.MarkDto;
//import com.codegym.dto.StudentDTO;
//import com.codegym.entity.about_schedule.Subject;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class MarkController_updateMark {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createStudent_name_13() throws Exception {
//        MarkDto markDto = new MarkDto();
//        markDto.setMarkPointNumber1(null);
//
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentId(1);
//        markDto.setStudent(studentDto);
//        Subject subject = new Subject();
//        subject.setSubjectId(1);
//        markDto.setSubject(subject);
//
//        markDto.setMarkPointNumber2(10.0);
//        markDto.setMarkPointNumber3(10.0);
//        markDto.setMarkId(1);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/marks/update")
//                .content(this.objectMapper.writeValueAsString(markDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_name_18() throws Exception {
//        MarkDto markDto = new MarkDto();
//        markDto.setMarkPointNumber1(10.0);
//
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentId(1);
//        markDto.setStudent(studentDto);
//        Subject subject = new Subject();
//        subject.setSubjectId(1);
//        markDto.setSubject(subject);
//
//        markDto.setMarkPointNumber2(10.0);
//        markDto.setMarkPointNumber3(10.0);
//        markDto.setMarkId(1);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/marks/update")
//                .content(this.objectMapper.writeValueAsString(markDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//}
