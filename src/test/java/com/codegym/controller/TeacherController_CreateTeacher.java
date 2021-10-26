package com.codegym.controller;

import com.codegym.DTO.TeacherDto;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class TeacherController_CreateTeacher {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createTeacher_name_18() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("da nang");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("bao@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("bao bao");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createTeacher_name_17() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("da nang");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("bao@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("bao bao bao bao bao bao bao bao bao bao bao bao bao bao");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTeacher_name_16() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("d");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("bao@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("bao bao bao bao bao bao bao bao bao bao bao bao bao bao");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTeacher_name_15() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("d");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("baogmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("bao bao bao bao bao bao bao bao bao bao bao bao bao bao");
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTeacher_name_14() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("bao bao bao bao bao bao bao bao bao bao bao bao bao bao");
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTeacher_name_13() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName(null);
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        Account account = new Account();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        Division division = new Division();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        Degree degree = new Degree();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/new")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
