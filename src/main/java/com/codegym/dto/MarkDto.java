package com.codegym.dto;

import com.codegym.entity.about_schedule.Subject;
import com.codegym.entity.about_student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkDto {

    private Integer markId;
    private Student student;
    private Subject subject;
    private Double markPointNumber1;
    private Double markPointNumber2;
    private Double markPointNumber3;
}
