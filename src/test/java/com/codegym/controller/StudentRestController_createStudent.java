//package com.codegym.controller;
//
//import com.codegym.dto.StudentDTO;
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
//public class StudentRestController_createStudent {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createStudent_name_13() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName(null);
//        studentDto.setStudentAddress("Huế");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_address_14() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName("Lam");
//        studentDto.setStudentAddress("");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_name_15() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName("123");
//        studentDto.setStudentAddress("Huế");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_name_16() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName("lam");
//        studentDto.setStudentAddress("Huế");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_name_17() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName("qưeqwewqeqweqweqwewqeqweqweqwewqewqewqewqwqwqewqwqa");
//        studentDto.setStudentAddress("Huế");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_18() throws Exception {
//        StudentDTO studentDto = new StudentDTO();
//        studentDto.setStudentName("Nguyen Thanh Lam");
//        studentDto.setStudentAddress("Huế");
//        studentDto.setStudentDateOfBirth("2000-10-16");
//        studentDto.setStudentEthnicity("Tày");
//        studentDto.setStudentFatherName("Huy");
//        studentDto.setStudentGender((byte) 0);
//        studentDto.setStudentImage("anh1.png");
//        studentDto.setStudentMotherName("Hùng");
//        studentDto.setStudentReligion("Không");
//        studentDto.setStudentStatus("Đang học");
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/students/add")
//                        .content(this.objectMapper.writeValueAsString(studentDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
