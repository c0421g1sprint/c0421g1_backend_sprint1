package com.codegym.dto;

import com.codegym.entity.about_classroom.Grade;
import com.codegym.entity.about_schedule.Schedule;
import com.codegym.entity.about_student.Student;
import com.codegym.entity.about_teacher.Teacher;
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

    private Grade grade;

    private boolean deleteFlag;

    private TeacherDto teacher;

    private Set<Student> students;

    private Schedule schedule;
}
