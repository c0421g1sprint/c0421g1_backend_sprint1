package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;

import java.util.List;

public interface IScheduleService {

    //TaiNP && QuanTA
    ScheduleDetail save (ScheduleDetail scheduleDetail);

    //TaiNP && QuanTA
    List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId);

    //TaiNP && QuanTA
    void updateSchedule (int updateValue, int idScheduleDetail);
}
