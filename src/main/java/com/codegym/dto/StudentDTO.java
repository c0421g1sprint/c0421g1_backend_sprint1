package com.codegym.dto;

import com.codegym.entity.about_classroom.Classroom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer studentId;
    private Byte studentGender;
    private String studentFatherName;
    private String studentMotherName;
    private String studentDateOfBirth;
    private String studentEthnicity;
    private String studentAddress;
    private String studentName;
    private String studentReligion;
    private String studentImage;
    private String studentStatus;
    private String studentParentPhone;
    private Classroom Classroom;
    private Set<MarkDto> mark;

}
