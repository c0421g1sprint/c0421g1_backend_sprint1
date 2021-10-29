package com.codegym.controller;

import com.codegym.dto.StudentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_editStudent {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editStudent_name_19() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName(null);
        studentDto.setStudentAddress("Huế");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_20() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName("Nguyen Thanh Binh");
        studentDto.setStudentAddress("");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_21() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName("123");
        studentDto.setStudentAddress("Huees");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_22() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName("lam");
        studentDto.setStudentAddress("Huees");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_23() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName("qưeqwewqeqweqweqwewqeqweqweqwewqewqewqewqwqwqewqwqa");
        studentDto.setStudentAddress("Huees");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_name_24() throws Exception {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setStudentName("Nguyen Thanh Binh");
        studentDto.setStudentAddress("Huế");
        studentDto.setStudentDateOfBirth("2000-10-16");
        studentDto.setStudentEthnicity("Tày");
        studentDto.setStudentFatherName("Huy");
        studentDto.setStudentGender((byte) 0);
        studentDto.setStudentImage("anh1.png");
        studentDto.setStudentMotherName("Hùng");
        studentDto.setStudentReligion("Không");
        studentDto.setStudentStatus("Đang học");
        studentDto.setStudentId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/students/edit")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
