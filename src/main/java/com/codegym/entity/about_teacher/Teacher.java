package com.codegym.entity.about_teacher;

import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_classroom.Classroom;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    private String teacherName;
    private Byte teacherGender;
    private String teacherDateOfBirth;
    private String teacherUniversity;
    private String teacherAddress;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherImage;

//    @JsonManagedReference
    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id", referencedColumnName = "degreeId")
    private Degree degree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @JsonBackReference(value = "teacher_classroom")
    @OneToOne(mappedBy = "teacher")
    private Classroom classroom;

    private boolean deleteFlag;
}
