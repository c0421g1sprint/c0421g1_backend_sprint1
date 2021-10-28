package com.codegym.entity.about_schedule;

import com.codegym.entity.about_classroom.Classroom;
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
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    private boolean deleteFlag;

    @OneToMany(mappedBy = "schedule")
    private Set<ScheduleDetail> scheduleDetails;
}
