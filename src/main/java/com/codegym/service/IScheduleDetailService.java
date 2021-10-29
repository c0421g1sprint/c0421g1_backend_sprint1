package com.codegym.service;

import com.codegym.entity.about_schedule.ScheduleDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IScheduleDetailService {

    //Phuc
    List<ScheduleDetail> getScheduleTeacher(Integer id);
}
