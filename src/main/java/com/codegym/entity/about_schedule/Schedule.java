package com.codegym.entity.about_schedule;

import com.codegym.entity.about_classroom.Classroom;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    private boolean deleteFlag;

    @OneToMany(mappedBy = "schedule")
    @JsonBackReference(value = "scheduleDetail_schedule")
    private Set<ScheduleDetail> scheduleDetails;
}
