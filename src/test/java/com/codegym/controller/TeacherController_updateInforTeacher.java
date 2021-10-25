package com.codegym.controller;

import com.codegym.dto.AccountDto;
import com.codegym.dto.DegreeDto;
import com.codegym.dto.DivisionDto;
import com.codegym.dto.TeacherDto;
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
    public void createStudent_name_24() throws Exception {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherName("Bùi Tiến Dũng");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1);
        teacherDto.setAccount(accountDto);

        DivisionDto divisionDto = new DivisionDto();
        divisionDto.setDivisionId(1);
        teacherDto.setDivision(divisionDto);

        DegreeDto degreeDto = new DegreeDto();
        degreeDto.setDegreeId(1);
        teacherDto.setDegree(degreeDto);

        teacherDto.setTeacherAddress("Bach Dang - Hải Châu - Đà Nẵng");
        teacherDto.setTeacherDateOfBirth("1988-11-11");
        teacherDto.setTeacherEmail("dung@gmail.com");

        teacherDto.setTeacherImage("https://toplist.vn/images/800px/studio-huu-tri-317829.jpg");
        teacherDto.setTeacherPhone("0810000009");
        teacherDto.setTeacherUniversity("Đại học Sư phạm Đà Nẵng");
        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/teachers/update")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createStudent_name_20() throws Exception {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherName("Bùi Tiến Dũng");

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1);
        teacherDto.setAccount(accountDto);

        DivisionDto divisionDto = new DivisionDto();
        divisionDto.setDivisionId(1);
        teacherDto.setDivision(divisionDto);

        DegreeDto degreeDto = new DegreeDto();
        degreeDto.setDegreeId(1);
        teacherDto.setDegree(degreeDto);

        teacherDto.setTeacherAddress("Bach Dang - Hải Châu - Đà Nẵng");
        teacherDto.setTeacherDateOfBirth("1988-11-11");
        teacherDto.setTeacherEmail("dung@gmail.com");

        teacherDto.setTeacherImage("https://toplist.vn/images/800px/studio-huu-tri-317829.jpg");
        teacherDto.setTeacherPhone("0810000009");
        teacherDto.setTeacherUniversity("Đại học Sư phạm Đà Nẵng");
        teacherDto.setDeleteFlag(false);
        teacherDto.setTeacherId(1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers/update")
                .content(this.objectMapper.writeValueAsString(teacherDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
