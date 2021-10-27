package com.codegym.DTO;

import com.codegym.entity.about_teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
