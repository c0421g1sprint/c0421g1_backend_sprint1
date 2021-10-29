package com.codegym.dto;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_student.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private Byte studentGender;
    private String studentFatherName;
    private String studentMotherName;
    private Date studentDateOfBirth;
    private String studentEthnicity;
    private String studentAddress;
    private String studentName;
    private String studentReligion;
    private String studentImage;
    private String studentStatus;
    private String studentParentPhone;

}
