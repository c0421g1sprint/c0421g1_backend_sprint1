package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;

import java.util.List;

public interface IScheduleService {
    ScheduleDetail save (ScheduleDetail scheduleDetail);
    List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId);
    void updateSchedule (int updateValue, int idScheduleDetail);
}
