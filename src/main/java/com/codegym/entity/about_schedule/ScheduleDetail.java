package com.codegym.entity.about_schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"study_day_time_id", "subject_id", "schedule_id"})})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleDetailId;

    @ManyToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subject subject;

    @ManyToOne(targetEntity = StudyDayTime.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "study_day_time_id", referencedColumnName = "studyDayTimeId")
    private StudyDayTime studyDayTime;

    @ManyToOne(targetEntity = Schedule.class)
    @JoinColumn(name = "schedule_id", referencedColumnName = "scheduleId")
    private Schedule schedule;

}
