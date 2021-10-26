package com.codegym.entity.about_teacher;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer degreeId;
    private String degreeName;

    @JsonBackReference
//    @JsonBackReference(value = "teacher_degree")
    @OneToMany(mappedBy = "degree")
    private Set<Teacher> teachers;
}
