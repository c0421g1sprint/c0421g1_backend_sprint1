package com.codegym.dto;

import com.codegym.entity.about_classroom.Classroom;
import com.codegym.entity.about_schedule.ScheduleDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;
    private Classroom classroom;
    private boolean deleteFlag;
    private Set<ScheduleDetail> scheduleDetails;
}
