package com.codegym.entity.about_schedule;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "scheduleDetailId")
public class ScheduleDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleDetailId;


//    @JsonBackReference(value = "scheduleDetail_subject")
    @ManyToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subject subject;

//    @JsonBackReference(value = "scheduleDetail_daytime")
    @ManyToOne(targetEntity = StudyDayTime.class)
    @JoinColumn(name = "study_day_time_id", referencedColumnName = "studyDayTimeId")
    private StudyDayTime studyDayTime;

    @ManyToOne(targetEntity = Schedule.class)
    @JoinColumn(name = "schedule_id", referencedColumnName = "scheduleId")
    private Schedule schedule;

}
