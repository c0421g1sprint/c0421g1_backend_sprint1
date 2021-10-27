package com.codegym.entity.about_schedule;

import com.codegym.entity.about_student.Mark;
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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    private String subjectName;

    @JsonBackReference(value = "mark_subject")
    @OneToMany(mappedBy = "subject")
    private Set<Mark> marks;
    

    @OneToMany(mappedBy = "subject")
    @JsonBackReference(value = "scheduleDetail_subject")
    private Set<ScheduleDetail> scheduleDetails;
}
