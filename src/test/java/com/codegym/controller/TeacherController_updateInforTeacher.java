package com.codegym.controller;


import com.codegym.dto.AccountDto;
import com.codegym.dto.DegreeDto;
import com.codegym.dto.DivisionDto;
import com.codegym.dto.TeacherDto;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
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
public class TeacherController_updateInforTeacher {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateInForTeacher_24() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("da nang");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("minh@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("minh");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(6);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void updateInForTeacher_23() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("da nang");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("minh@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(1);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateInForTeacher_22() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("abc");
        teacherDto.setTeacherDateOfBirth("01/10/2000");

        teacherDto.setTeacherEmail("minh@gmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("minh");
        teacherDto.setTeacherPhone("0905330270");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(1);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateInForTeacher_21() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("d");
        teacherDto.setTeacherDateOfBirth("01/10/2000");

        teacherDto.setTeacherEmail("minhgmail.com");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("minh");
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(1);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateInForTeacher_20() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("");
        teacherDto.setTeacherDateOfBirth("01/10/2000");

        teacherDto.setTeacherEmail("");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName("minh");
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateInForTeacher_19() throws Exception {
        TeacherDto teacherDto =new TeacherDto();

        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherAddress("");
        teacherDto.setTeacherDateOfBirth("23/11/2000");

        teacherDto.setTeacherEmail("");
        teacherDto.setTeacherImage("anh.png");
        teacherDto.setTeacherName(null);
        teacherDto.setTeacherPhone("0905330270123456");
        teacherDto.setTeacherUniversity("dai hoc da nang");

        AccountDto account = new AccountDto();
        account.setAccountId(1);
        teacherDto.setAccount(account);

        DivisionDto division = new DivisionDto();
        division.setDivisionId(1);
        teacherDto.setDivision(division);

        DegreeDto degree = new DegreeDto();
        degree.setDegreeId(1);
        teacherDto.setDegree(degree);

        teacherDto.setTeacherId(1);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/updateInFor")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
