package com.codegym.entity.about_teacher;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;
    private String divisionName;

//    @JsonBackReference
    @JsonBackReference(value = "teacher_division")
    @OneToMany(mappedBy = "division")
    private Set<Teacher> teachers;
}
