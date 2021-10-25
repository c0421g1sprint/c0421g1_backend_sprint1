package com.codegym;

import com.codegym.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClassroomController_create {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createClassroom_name_13() throws Exception {

        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassroomName(null);
        classroomDto.setClassroomSchoolYear("2021");
        classroomDto.setDeleteFlag(false);

        GradeDto gradeDto = new GradeDto();
        gradeDto.setGradeId(2);
        classroomDto.setGrade(gradeDto);

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(6);
        classroomDto.setTeacher(teacherDto);

        Set<StudentDto> studentDtoSet =  new HashSet<>();
        for (int i = 0; i<=5; i++) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(i++);
            studentDtoSet.add(studentDto);
        }
        classroomDto.setStudents(studentDtoSet);


        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheduleId(1);
        classroomDto.setSchedule(scheduleDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/class-room/create")
                .content(this.objectMapper.writeValueAsString(classroomDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createClassroom_name_14() throws Exception {

        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassroomName("");
        classroomDto.setClassroomSchoolYear("2021");
        classroomDto.setDeleteFlag(false);

        GradeDto gradeDto = new GradeDto();
        gradeDto.setGradeId(2);
        classroomDto.setGrade(gradeDto);

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(6);
        classroomDto.setTeacher(teacherDto);

        Set<StudentDto> studentDtoSet =  new HashSet<>();
        for (int i = 0; i<=5; i++) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(i++);
            studentDtoSet.add(studentDto);
        }
        classroomDto.setStudents(studentDtoSet);


        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheduleId(2);
        classroomDto.setSchedule(scheduleDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/class-room/create")
                .content(this.objectMapper.writeValueAsString(classroomDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createClassroom_name_15() throws Exception {

        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassroomName("1A7");
        classroomDto.setClassroomSchoolYear("2021");
        classroomDto.setDeleteFlag(false);

        GradeDto gradeDto = new GradeDto();
        gradeDto.setGradeId(2);
        classroomDto.setGrade(gradeDto);

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(6);
        classroomDto.setTeacher(teacherDto);

        Set<StudentDto> studentDtoSet =  new HashSet<>();
        for (int i = 0; i<=5; i++) {
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(i++);
            studentDtoSet.add(studentDto);
        }
        classroomDto.setStudents(studentDtoSet);


        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheduleId(4);
        classroomDto.setSchedule(scheduleDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/class-room/create")
                .content(this.objectMapper.writeValueAsString(classroomDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
