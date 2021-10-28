package com.codegym.dto;

import com.codegym.entity.about_classroom.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomPageDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

    private String classroomName;

    private String classroomSchoolYear;

    private Grade grade;

    private boolean deleteFlag;

    private TeacherDto teacherDto;
}
