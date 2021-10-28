package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

    private String classroomName;

    private String classroomSchoolYear;

    private com.codegym.dto.GradeDto grade;

    private boolean deleteFlag;

    private com.codegym.dto.TeacherDto teacher;

    private Set<com.codegym.dto.StudentDto> students;

    private com.codegym.dto.ScheduleDto schedule;
}
