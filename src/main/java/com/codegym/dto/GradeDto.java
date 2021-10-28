package com.codegym.dto;

import com.codegym.entity.about_classroom.Classroom;
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
public class GradeDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;
    private String gradeName;

    private Set<Classroom> classrooms;
}
