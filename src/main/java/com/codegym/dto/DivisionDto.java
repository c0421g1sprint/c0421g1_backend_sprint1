package com.codegym.dto;

import com.codegym.entity.about_teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DivisionDto {

    private Integer divisionId;
    private String divisionName;
    private Set<Teacher> teachers;
}
