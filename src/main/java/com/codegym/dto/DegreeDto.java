package com.codegym.DTO;

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
public class DegreeDto {

    private Integer degreeId;
    private String degreeName;
    private Set<Teacher> teachers;
}
