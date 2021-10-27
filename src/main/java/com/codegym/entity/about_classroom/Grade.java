package com.codegym.entity.about_classroom;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;
    private String gradeName;

    @JsonBackReference
//    @JsonBackReference(value = "classroom_grade")
    @OneToMany(mappedBy = "grade")
    private Set<Classroom> classrooms;
}
