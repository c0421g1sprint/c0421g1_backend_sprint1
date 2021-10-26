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

    private GradeDto grade;

    private boolean deleteFlag;

    private TeacherDto teacher;

    private Set<StudentDto> students;

    private ScheduleDto schedule;
}
