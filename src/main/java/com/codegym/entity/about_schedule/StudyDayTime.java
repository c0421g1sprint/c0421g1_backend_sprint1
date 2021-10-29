package com.codegym.entity.about_schedule;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyDayTime implements Serializable {
    @Id
    private Integer studyDayTimeId;
    private String studyDayTimeStudyTime;
    private String studyDayTimeStudyDay;

    @OneToMany(mappedBy = "studyDayTime")
    @JsonBackReference(value = "scheduleDetail_daytime")
    private Set<ScheduleDetail> scheduleDetails;
}
