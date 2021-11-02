package com.codegym.dto;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_teacher.Degree;
import com.codegym.entity.about_teacher.Division;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private Integer teacherId;
    private String teacherName;
    private Byte teacherGender;
    private String teacherDateOfBirth;
    private String teacherUniversity;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherImage;

    private Degree degree;

    private Division division;

    private Account account;

    private Classroom classroom;

    private boolean deleteFlag;
}
