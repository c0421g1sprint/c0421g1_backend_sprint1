package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;

import java.util.List;

public interface IScheduleService {


    //TaiNP && QuanTA
    List<ScheduleDetail> findScheduleDetailByClassroomId(Integer classroomId);

    //TaiNP && QuanTA
    void updateSchedule (Integer updateValue, Integer idScheduleDetail);
}
