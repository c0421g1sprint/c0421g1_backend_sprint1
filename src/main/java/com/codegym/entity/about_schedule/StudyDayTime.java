package com.codegym.entity.about_schedule;
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
public class StudyDayTime {
    @Id
    private String studyDayTimeId;
    private String studyDayTimeStudyTime;
    private String studyDayTimeStudyDay;

    @OneToMany(mappedBy = "studyDayTime")
    private Set<ScheduleDetail> scheduleDetails;
}
